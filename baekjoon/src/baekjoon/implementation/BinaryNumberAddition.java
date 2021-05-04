package baekjoon.implementation;

import java.io.*;

public class BinaryNumberAddition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] results = new String[T];

        for(int i=0; i<T; i++) {
            String[] target = br.readLine().split(" ");
            if(isZero(target[0]) && isZero(target[1])) {
                results[i] = "0";
            } else {
                results[i] = add(target[0], target[1]);
            }
        }

        for(int i=0; i<T; i++) {
            System.out.println(results[i]);
        }
    }

    public static boolean isZero(String str) {
        boolean isZero = true;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '1') {
                isZero = false;
                break;
            }
        }

        return isZero;
    }

    public static String add(String before, String after) {
        int length = Math.max(before.length(), after.length());

        String reverseBefore = new StringBuilder(before).reverse().toString();
        String reverseAfter = new StringBuilder(after).reverse().toString();
        StringBuilder reverseResult = new StringBuilder();

        int carry = 0;
        for(int i=0; i<length; i++) {
            int beforeChar;
            if(i < reverseBefore.length()) {
                beforeChar = Integer.valueOf(reverseBefore.charAt(i) - '0');
            } else {
                beforeChar = 0;
            }

            int afterChar;
            if(i < reverseAfter.length()) {
                afterChar = Integer.valueOf(reverseAfter.charAt(i) - '0');
            } else {
                afterChar = 0;
            }

            int result = 0;
            int sum = beforeChar + afterChar + carry;
            carry = 0;

            if(sum == 0) {
                result = 0;
            } else if(sum == 1) {
                result = 1;
            } else if(sum == 2) {
                result = 0;
                carry = 1;
            } else if(sum == 3) {
                result = 1;
                carry = 1;
            }

            reverseResult.append(result);
        }
        if(carry == 1) {
            reverseResult.append(carry);
        }

        String result = reverseResult.reverse().toString();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '1') {
                result = result.substring(i);
                break;
            }
        }

        return result;
    }
}

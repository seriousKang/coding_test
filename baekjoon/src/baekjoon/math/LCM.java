package baekjoon.math;

import java.io.*;

/**
 * #1934 최소공배수(https://www.acmicpc.net/problem/1934)
 */
public class LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());
        String[] cases = new String[T];
        for(int i=0; i<T; i++) {
            cases[i] = br.readLine();
        }

        for(int i=0; i<T; i++) {
            String[] values = cases[i].split(" ");
            int num1 = Integer.valueOf(values[0]);
            int num2 = Integer.valueOf(values[1]);

            System.out.println(num1 * num2 / GCD(num1, num2));
        }

        br.close();
    }

    public static int GCD(int num1, int num2) {
        if(num2 > num1) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }

        while(num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1;
    }
}

package baekjoon.simple;

import java.util.*;

public class CrossCardProblem {
    static String[] arr = new String[4];
    static int minNum;
    static List<Integer> clockNumList = new ArrayList<>();

    public static void main(String[] args) {
        intializeClockNumList();

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        arr = line.split(" ");

        StringBuilder input = new StringBuilder();
        for(int i=0; i<4; i++) {
            input.append(arr[i]);
        }
        minNum = getMinClockNum(Integer.parseInt(input.toString()));

        int resultIndex = clockNumList.indexOf(minNum) + 1;
        System.out.println(resultIndex);

        sc.close();
    }

    public static void intializeClockNumList() {
        for(int i=1111; i<=9999; i++) {
            if(String.valueOf(i).contains("0")) {
                continue;
            }

            int minClockNum = getMinClockNum(i);
            if(!clockNumList.contains(minClockNum)) {
                clockNumList.add(minClockNum);
            }
        }
    }

    public static int getMinClockNum(int num) {
        String str = String.valueOf(num);

        int[] clockNumArr = new int[4];
        for(int i=0; i<4; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(i%4))
                    .append(str.charAt((i+1)%4))
                    .append(str.charAt((i+2)%4))
                    .append(str.charAt((i+3)%4));

            clockNumArr[i] = Integer.parseInt(sb.toString());
        }
        Arrays.sort(clockNumArr);

        return clockNumArr[0];
    }
}

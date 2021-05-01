package baekjoon.implementation;

import java.util.*;

public class Hansu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int hansuCnt = 0;

        for(int i=1; i<=N; i++) {
            if(isHansu(i)) hansuCnt++;
//            System.out.println(i + ":" + isHansu(i));
        }
        System.out.println(hansuCnt);

        sc.close();
    }

    public static boolean isHansu(Integer num) {
        String[] arr = String.valueOf(num).split("");
        int[] numArr = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }

        if(2 < numArr.length) {
            int diff = numArr[1] - numArr[0];

            for(int i=2; i<numArr.length; i++) {
                if(numArr[i]-numArr[i-1] != diff) {
                    return false;
                }
            }
        }

        return true;
    }
}

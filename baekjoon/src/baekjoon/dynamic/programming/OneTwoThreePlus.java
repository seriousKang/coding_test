package baekjoon.dynamic.programming;

import java.util.*;

public class OneTwoThreePlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        int[] caseArr = new int[11];
        initializeCaseArr(caseArr);

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int num: arr) {
            System.out.println(caseArr[num]);
        }

        sc.close();
    }

    public static void initializeCaseArr(int[] caseArr) {
        caseArr[1] = 1;
        caseArr[2] = 2;
        caseArr[3] = 4;
        for(int i=4; i<=10; i++) {
            int tempSum = 0;
            for(int j=i-3; j<i; j++) {
                tempSum += caseArr[j];
            }
            caseArr[i] = tempSum;
        }        
    }
}

package baekjoon.math;

import java.util.*;

/**
 * #2609 최대공약수와 최소공배수(https://www.acmicpc.net/problem/2609)
 */
public class GCDAndLCM2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        if(N < M) {
            int temp = N;
            N = M;
            M = temp;
        }

        System.out.println(GCD(N, M));
        System.out.println(N * M / GCD(N, M));

        sc.close();
    }

    public static int GCD(int num1, int num2) {
        int temp;
        while(num2 != 0) {
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1;
    }
}

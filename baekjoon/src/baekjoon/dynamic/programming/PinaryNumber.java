package baekjoon.dynamic.programming;

import java.util.*;

/**
 * #2193 이친수(https://www.acmicpc.net/problem/2193)
 */
public class PinaryNumber {
    static int MAX_SIZE = 90;
    static long[] one = new long[MAX_SIZE+1];
    static long[] zero = new long[MAX_SIZE+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initialize();

        int N = sc.nextInt();
//        for(int i=1; i<=90; i++) {
//            System.out.printf("[%d] %d + %d = %d\n", i, one[i], zero[i], one[i]+zero[i]);
//        }
        System.out.println(one[N] + zero[N]);

        sc.close();
    }

    public static void initialize() {
        one[1] = 1;
        zero[1] = 0;

        for(int i=2; i<=90; i++) {
            one[i] = zero[i-1];
            zero[i] = zero[i-1] + one[i-1];
        }
    }
}

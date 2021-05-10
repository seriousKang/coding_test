package baekjoon.implementation;

import java.util.*;

/**
 * #2960 에라토스테네스의 체(https://www.acmicpc.net/problem/2960)
 */
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] arr = new boolean[N+1];

        int result = 0;
        int cnt = 0;
        int start = 2;
        while(true) {
            for(int i=1; i*start<=N; i++) {
                int tempIdx = i*start;

                if(arr[tempIdx] == false) {
                    cnt++;
                    arr[tempIdx] = true;
                }

                if(cnt == K) {
                    result = tempIdx;
                    break;
                }
            }

            if(result != 0) {
                System.out.println(result);
                break;
            }
            start++;
        }

        sc.close();
    }
}

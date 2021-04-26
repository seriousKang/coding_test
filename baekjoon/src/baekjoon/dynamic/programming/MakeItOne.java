package baekjoon.dynamic.programming;

import java.util.*;

public class MakeItOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[1000001];

        arr[1] = 0;
        for(int i=2; i<=N; i++) {
            arr[i] = arr[i-1] + 1;
            if(i%3 == 0) {
                arr[i] = Math.min(arr[i], arr[i/3]+1);
            }
            if(i%2 == 0) {
                arr[i] = Math.min(arr[i], arr[i/2]+1);
            }
        }
        System.out.println(arr[N]);

        sc.close();
    }
}

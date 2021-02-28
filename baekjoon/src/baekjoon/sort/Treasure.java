package baekjoon.sort;

import java.util.*;

public class Treasure {
    static int N;
    static int[] A;
    static int[] B;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];
        B = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<N; i++) {
            result += A[i] * B[N-i-1];
        }
        System.out.println(result);

        sc.close();
    }
}

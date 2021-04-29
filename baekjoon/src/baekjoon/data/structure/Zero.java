package baekjoon.data.structure;

import java.util.*;

public class Zero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[100000];
        int cursor = -1;

        for(int i=0; i<N; i++) {
            int next = sc.nextInt();

            if(next != 0) {
                arr[++cursor] = next;
            } else {
                cursor--;

                if(cursor < -1) {
                    cursor = -1;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<=cursor; i++) {
            sum += arr[i];
        }
        System.out.println(sum);

        sc.close();
    }
}

package baekjoon.dynamic.programming;

import java.io.*;

public class Fibonacci {
    static int[] arr0;
    static int[] arr1;
    static int MAX_SIZE = 40;

    public static void main(String[] args) throws IOException {
        initialize();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];

        for(int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int num: arr) {
            System.out.println(arr0[num] + " " + arr1[num]);
        }

        br.close();
    }

    public static void initialize() {
        arr0 = new int[MAX_SIZE + 1];
        arr1 = new int[MAX_SIZE + 1];

        arr0[0] = 1;
        arr0[1] = 0;

        arr1[0] = 0;
        arr1[1] = 1;

        for(int i=2; i<=40; i++) {
            arr0[i] = arr0[i-2] + arr0[i-1];
            arr1[i] = arr1[i-2] + arr1[i-1];
        }
    }
}

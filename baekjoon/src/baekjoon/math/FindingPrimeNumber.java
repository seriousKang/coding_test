package baekjoon.math;

import java.util.*;
import java.io.*;

public class FindingPrimeNumber {
    static boolean[] primeArr = new boolean[1001];

    public static void initialize() {
        Arrays.fill(primeArr, true);
        primeArr[0] = false;
        primeArr[1] = false;

        for(int i=2; i<=500; i++) {
            if(primeArr[i]) {
                int j = 2;
                while (j * i <= 1000) {
                    primeArr[i * j++] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        initialize();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int result = 0;

        for(int i=0; i<N; i++) {
            if(primeArr[Integer.parseInt(arr[i])]) result++;
        }
        System.out.println(result);

        br.close();
    }
}

package baekjoon.dynamic.programming;

import java.util.*;

public class FillingTile {
    static int[] arr = new int[31];

    public static int dp(int n) {
        if(n%2 != 0) return 0;

        if(n == 2) {
            return 3;
        } else if(arr[n] == 0) {
            arr[n] = dp(n-2)*3 + 2;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = dp(N);
        System.out.println(result);

        sc.close();
    }
}

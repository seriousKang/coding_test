package baekjoon.dynamic.programming;

import java.util.*;

public class TwoXNTiling2 {
    static int[] resultArr = new int[1000];

    public static int dp(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 3;
        } else if(resultArr[n-1] == 0) {
            resultArr[n-1] = dp(n-2)*2 + dp(n-1);
        }

        return resultArr[n-1] % 10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = dp(n);
        System.out.println(result);

        sc.close();
    }
}

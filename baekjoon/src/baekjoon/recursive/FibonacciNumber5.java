package baekjoon.recursive;

import java.util.*;

public class FibonacciNumber5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long result = fibonacci(n);
        System.out.println(result);

        sc.close();
    }

    public static long fibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}

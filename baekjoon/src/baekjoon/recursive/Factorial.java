package baekjoon.recursive;

import java.util.*;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long result = factorial(N);
        System.out.println(result);

        sc.close();
    }

    public static long factorial(long num) {
        if(num == 0) {
            return 1;
        }

        return num * factorial(num-1);
    }
}

package baekjoon.dynamic.programming;

import java.util.*;

public class TwoXNTiling {
    static int[] methodArr = new int[1000];

    public static int getNumOfMethod(int n) {
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else if (methodArr[n-1] == 0) {
            methodArr[n-1] = getNumOfMethod(n-1) + getNumOfMethod(n-2);
        }

        return methodArr[n-1] % 10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = getNumOfMethod(n);
        System.out.println(result);

        sc.close();
    }
}

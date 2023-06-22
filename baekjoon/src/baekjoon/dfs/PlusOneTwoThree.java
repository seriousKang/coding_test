package baekjoon.dfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/9095
 */
public class PlusOneTwoThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testSize = scanner.nextInt();
        int[] testCases = new int[testSize];

        for(int i=0; i<testSize; i++) {
            testCases[i] = scanner.nextInt();
        }

        int[] result = initialize(10);
        Arrays.stream(testCases)
                .forEach(testCase -> System.out.println(result[testCase]));

        scanner.close();
    }

    private static int[] initialize(int maxNum) {
        int[] result = new int[maxNum + 1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for(int i=4; i<=maxNum; i++) {
            result[i] = result[i-3] + result[i-2] + result[i-1];
        }

        return result;
    }
}

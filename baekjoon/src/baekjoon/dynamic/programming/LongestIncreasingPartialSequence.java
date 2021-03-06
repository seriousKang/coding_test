package baekjoon.dynamic.programming;

import java.util.*;

public class LongestIncreasingPartialSequence {
    static int size;
    static int[] arr;
    static Integer[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        arr = new int[size];
        result = new Integer[size];

        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
            result[i] = 1;
        }

        for(int i=1; i<size; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i]>arr[j] && result[j]>=result[i]) {
                    result[i] = result[j]+1;
                }
            }
        }
        Arrays.sort(result, Comparator.reverseOrder());
//        System.out.println(Arrays.toString(result));
        System.out.println(result[0]);

        sc.close();
    }
}

package baekjoon.implementation;

import java.util.*;

/**
 * #2331 반복수열(https://www.acmicpc.net/problem/2331)
 */
public class RepeatSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int P = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        int current = A;
        int repeatValue = 0;
        list.add(A);
        while(true) {
            int next = next(current, P);
            if(list.contains(next)) {
                repeatValue = next;
                break;
            } else {
                list.add(next);
                current = next;
            }
        }

        int cnt=0;
        for(int value: list) {
            if(value == repeatValue) {
                break;
            }

            cnt++;
        }
        System.out.println(cnt);

        sc.close();
    }

    public static int next(int A, int P) {
        String[] arr = String.valueOf(A).split("");
        int sum = 0;
        for(String str: arr) {
            sum += Math.pow(Integer.valueOf(str), P);
        }

        return sum;
    }
}

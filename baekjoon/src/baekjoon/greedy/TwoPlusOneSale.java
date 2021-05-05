package baekjoon.greedy;

import java.io.*;
import java.util.*;

/**
 * #11508 2+1 세일(https://www.acmicpc.net/problem/11508)
 */
public class TwoPlusOneSale {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] prices = new Integer[N];

        for(int i=0; i<N; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(prices, Comparator.reverseOrder());
//        System.out.println(Arrays.toString(prices));

        int sum = 0;
        for(int i=0; i<N; i++) {
            if((i+1) % 3 == 0) continue;

            sum += prices[i];
        }
        System.out.println(sum);

        br.close();
    }
}

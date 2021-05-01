package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class GasStation {
    static int MAX_PRICE = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] distances = new long[N-1];
        long[] gasPrices = new long[N];

        String[] distancesStrArr = br.readLine().split(" ");
        String[] gasPricesStrArr = br.readLine().split(" ");

        for(int i=0; i<distancesStrArr.length; i++) {
            distances[i] = Integer.parseInt(distancesStrArr[i]);
        }

        long minPrice = MAX_PRICE;
        for(int i=0; i<gasPricesStrArr.length; i++) {
            minPrice = Math.min(
                    Integer.parseInt(gasPricesStrArr[i]),
                    minPrice
            );

            gasPrices[i] = minPrice;
        }
//        System.out.println(Arrays.toString(gasPrices));

        long result = 0;
        for(int i=0; i<N-1; i++) {
            result += (gasPrices[i] * distances[i]);
        }
        System.out.println(result);

        br.close();
    }
}

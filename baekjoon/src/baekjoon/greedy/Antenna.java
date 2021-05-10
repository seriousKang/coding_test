package baekjoon.greedy;

import java.io.*;
import java.util.*;

/**
 * #18310 안테나(https://www.acmicpc.net/problem/18310)
 */
public class Antenna {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        String[] strArr = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for(String str: strArr) {
            list.add(Integer.valueOf(str));
        }
        Collections.sort(list);

        int target = N%2==0 ? N/2-1 : N/2;
        System.out.println(list.get(target));

        br.close();
    }
}

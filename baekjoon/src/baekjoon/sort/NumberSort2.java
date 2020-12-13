package baekjoon.sort;

import java.io.*;
import java.util.*;

public class NumberSort2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] numArr = new int[N];

        for(int i=0; i<N; i++) {
            numArr[i] = Integer.valueOf(br.readLine());
        }
//        System.out.println(Arrays.toString(numArr));
        br.close();

        Arrays.sort(numArr);
//        System.out.println(Arrays.toString(numArr));
        for(int i=0; i<N; i++) {
            bw.write(numArr[i] + "\n");
        }
        bw.close();
    }
}

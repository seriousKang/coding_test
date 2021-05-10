package baekjoon.greedy;

import java.io.*;
import java.util.*;

/**
 * #1343 폴리오미노(https://www.acmicpc.net/problem/1343)
 */
public class Polyomino {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();

        for(int i=0; i<str.length(); i++) {
            if(arr[i] == 'X') {
                if(i+1 < str.length() && arr[i+1] == 'X' &&
                   i+2 < str.length() && arr[i+2] == 'X' &&
                   i+3 < str.length() && arr[i+3] == 'X') {
                    arr[i] = arr[i+1] = arr[i+2] = arr[i+3] = 'A';
                    i += 3;
                    continue;
                }

                if((i+1 < str.length() && arr[i+1] == 'X') &&
                   (i+2 == str.length() || (i+2 < str.length() && arr[i+2] == '.'))) {
                    arr[i] = arr[i+1] = 'B';
                    i += 1;
                }
            }
//            System.out.println(Arrays.toString(arr));
        }

        String result = new String(arr);
        if(result.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

        br.close();
    }
}

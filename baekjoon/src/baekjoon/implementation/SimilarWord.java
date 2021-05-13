package baekjoon.implementation;

import java.io.*;
import java.util.*;

/**
 * #2607 비슷한 단어(https://www.acmicpc.net/problem/2607)
 */
public class SimilarWord {
    static int ALP_SIZE = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordNum = Integer.valueOf(br.readLine());
        String target = br.readLine();

        int result = 0;
        for(int i=0; i<wordNum-1; i++) {
            String str = br.readLine();

            if(compareStr(target, str)) {
                result++;
            }
        }
        System.out.println(result);

        br.close();
    }

    public static boolean compareStr(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        int[] arr1 = getAlpCntArr(str1);
        int[] arr2 = getAlpCntArr(str2);

        int diffCnt = 0;
        for(int i=0; i<ALP_SIZE; i++) {
            diffCnt += Math.abs(arr1[i] - arr2[i]);
        }

        if(diffCnt == 0) {
            return true;
        } else if(str1.length() == str2.length() && diffCnt == 2) {
            return true;
        } else if(str1.length() != str2.length() && diffCnt == 1) {
            return true;
        }

        return false;
    }

    public static int[] getAlpCntArr(String str) {
        int[] arr = new int[ALP_SIZE];

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            arr[c - 'A'] += 1;
        }

        return arr;
    }
}

package baekjoon.implementation;

import java.io.*;
import java.util.*;

/**
 * #1235 학생 번호(https://www.acmicpc.net/problem/1235)
 */
public class StudentNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        String[] arr = new String[N];

        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }

        int numberLen = arr[0].length();
        int result = 0;

        for(int i=1; i<=numberLen; i++) {
            Set set = new HashSet<>();
            boolean complete = true;

            for(int j=0; j<N; j++) {
                String temp = arr[j].substring(numberLen - i);

                if(!set.contains(temp)) {
                    set.add(temp);
                } else {
                    complete = false;
                    break;
                }
            }

            if(complete) {
                result = i;
                break;
            }
        }
        System.out.println(result);

        br.close();
    }
}

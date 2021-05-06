package baekjoon.implementation;

import java.io.*;
import java.util.*;

/**
 * #2910 빈도 정렬(https://www.acmicpc.net/problem/2910)
 */
public class FrequencySorting {
    static int CNT_MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] conditions = br.readLine().split(" ");
        String[] strValues = br.readLine().split(" ");

        int N = Integer.valueOf(conditions[0]);
        int C = Integer.valueOf(conditions[1]);
        Map<Integer, Integer> valueCnt = new LinkedHashMap<>();

        for(int i=0; i<N; i++) {
            int value = Integer.valueOf(strValues[i]);
            if(!valueCnt.containsKey(value)) {
                valueCnt.put(value, 1);
            } else {
                int cnt = valueCnt.get(value);
                valueCnt.put(value, cnt+1);
            }
        }

        int[] cntArr = new int[CNT_MAX+1];
        for(Map.Entry<Integer, Integer> entry: valueCnt.entrySet()) {
            cntArr[entry.getValue()] += 1;
        }
//        System.out.println(Arrays.toString(cntArr));

        StringBuilder sb = new StringBuilder();
        for(int i=CNT_MAX; i>=1; i--) {
            int cnt = cntArr[i];

            if(cnt == 0) {
                continue;
            }

            for(Map.Entry<Integer, Integer> entry: valueCnt.entrySet()) {
                if(entry.getValue() == i) {
                    for(int j=0; j<i; j++) {
                        sb.append(entry.getKey()).append(" ");
                    }

                    cnt--;
                }

                if(cnt == 0) {
                    break;
                }
            }
        }

        System.out.println(sb.substring(0, sb.length()-1).toString());
        br.close();
    }
}

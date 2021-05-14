package baekjoon.implementation;

import java.util.*;
import java.io.*;

/**
 * #1966 프린터 큐(https://www.acmicpc.net/problem/1966)
 */
public class PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.valueOf(br.readLine());
        int[] result = new int[testCase];
        for(int i=0; i<testCase; i++) {
            String[] status = br.readLine().split(" ");
            int len = Integer.valueOf(status[0]);
            int target = Integer.valueOf(status[1]);

            String[] strImportances = br.readLine().split(" ");
            int[] importances = new int[len];
            for(int j=0; j<len; j++) {
                importances[j] = Integer.valueOf(strImportances[j]);
            }

            result[i] = getOrder(importances, target);
        }

        for(int i=0; i<testCase; i++) {
            System.out.println(result[i]);
        }

        br.close();
    }

    public static int getOrder(int[] arr, int targetIdx) {
        List<Integer> list = new ArrayList<>();
        for(int num: arr) {
            list.add(num);
        }

        int cnt = 0;
        while(true) {
            if(targetIdx != 0) {
                if(isPollTarget(list)) {
                    cnt++;
                    list.remove(0);
                } else {
                    int move = list.get(0);
                    list.remove(0);
                    list.add(move);
                }

                targetIdx--;
            } else {
                if(isPollTarget(list)) {
                    cnt++;
                    break;
                } else {
                    int move = list.get(0);
                    list.remove(0);
                    list.add(move);
                    targetIdx = list.size()-1;
                }
            }
        }

        return cnt;
    }

    public static boolean isPollTarget(List<Integer> list) {
        boolean isPollTarget = true;

        int target = list.get(0);
        for(int i=1; i<list.size(); i++) {
            if(target < list.get(i)) {
                isPollTarget = false;
                break;
            }
        }

        return isPollTarget;
    }
}

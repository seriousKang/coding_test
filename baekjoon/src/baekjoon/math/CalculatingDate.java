package baekjoon.math;

import java.io.*;

/**
 * #1476 날짜 계산(https://www.acmicpc.net/problem/1476)
 */
public class CalculatingDate {
    static int BASE_E = 15;
    static int BASE_S = 28;
    static int BASE_M = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conditions = br.readLine().split(" ");

        int E = Integer.valueOf(conditions[0]);
        int S = Integer.valueOf(conditions[1]);
        int M = Integer.valueOf(conditions[2]);

        int result=0;
        while(true) {
            result++;

            int resultE = calculate(BASE_E, result);
            int resultS = calculate(BASE_S, result);
            int resultM = calculate(BASE_M, result);

            if(resultE == E && resultS == S && resultM == M) {
                break;
            }
        }
        System.out.println(result);

        br.close();
    }

    public static int calculate(int baseDate, int targetDate) {
        int result;
        if(targetDate % baseDate == 0) {
            result = baseDate;
        } else {
            result = targetDate % baseDate;
        }

        return result;
    }
}

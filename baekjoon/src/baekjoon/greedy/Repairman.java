package baekjoon.greedy;

import java.io.*;

public class Repairman {
    static int MAX_POSITION = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] condition = br.readLine().split(" ");
        int N = Integer.parseInt(condition[0]);
        int L = Integer.parseInt(condition[1]);

        String[] strLeakPosition = br.readLine().split(" ");
        boolean[] leakPosition = new boolean[MAX_POSITION+1];

        for(int i=0; i<N; i++) {
            int position = Integer.parseInt(strLeakPosition[i]);
            leakPosition[position] = true;
        }

        int result=0;
        for(int i=1; i<=MAX_POSITION; i++) {
            if(leakPosition[i]) {
                result++;
                for(int j=i; j<i+L && j<=MAX_POSITION; j++) {
                    if(leakPosition[j]) {
                        leakPosition[j] = false;
                        N--;
                    }
                }
            }

            if(N == 0) {
                break;
            }
        }
        System.out.println(result);

        br.close();
    }
}

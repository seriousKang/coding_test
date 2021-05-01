package baekjoon.implementation;

import java.io.*;

public class WriteNumberContinually1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int divisor = 10;
        int plus = 1;
        int cnt = 0;

        for(int i=1; i<=N; i++) {
            if(i % divisor == 0) {
                plus++;
                divisor *= 10;
            }

            cnt += plus;
        }

        System.out.println(cnt);

        br.close();
    }
}

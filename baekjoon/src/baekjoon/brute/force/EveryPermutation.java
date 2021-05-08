package baekjoon.brute.force;

import java.io.*;
import java.util.*;

public class EveryPermutation {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.valueOf(br.readLine());

        for(int i=1; i<=N; i++) {
            Set<Integer> set = new LinkedHashSet();
            set.add(i);

            loop(N, set);
        }

        br.close();
        bw.close();
    }

    public static void loop(int N, Set<Integer> set) throws IOException {
        if(set.size() == N) {
            StringBuilder sb = new StringBuilder();
            for(int num: set) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            bw.write(sb.toString());
            return;
        }

        for(int i=1; i<=N; i++) {
            if(set.contains(i)) {
                continue;
            } else {
                set.add(i);
                loop(N, set);

                set.remove(i);
            }
        }
    }
}

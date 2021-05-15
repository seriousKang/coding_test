package baekjoon.implementation;

import java.io.*;
import java.util.*;

/**
 * #15649 N과 M (1)(https://www.acmicpc.net/problem/15649)
 */
public class NAndM {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] visited;
    static List<Integer> list;
    static int maxNum;
    static int printNum;

    public static void main(String[] args) throws IOException {
        String[] conditions = br.readLine().split(" ");
        maxNum = Integer.valueOf(conditions[0]);
        printNum = Integer.valueOf(conditions[1]);

        for(int i=1; i<=maxNum; i++) {
            visited = new boolean[maxNum+1];
            list = new ArrayList<>();

            visited[i] = true;
            list.add(i);

            permutation(1);
        }

        br.close();
        bw.close();
    }

    public static void permutation(int cnt) throws IOException {
        if(cnt == printNum) {
            printList();
            return;
        }

        for(int i=1; i<=maxNum; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);

                permutation(cnt+1);

                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    public static void printList() throws IOException {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

        sb.setLength(sb.length()-1);
        sb.append("\n");
        bw.write(sb.toString());
    }
}

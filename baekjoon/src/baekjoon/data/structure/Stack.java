package baekjoon.data.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10001];
        int cur=0;

        int N = Integer.parseInt(br.readLine());
        String[] commands = new String[N];
        for(int i=0; i<N; i++) {
            commands[i] = br.readLine();
        }

        for(int i=0; i<N; i++) {
            if(commands[i].startsWith("push")) {
                arr[++cur] = Integer.parseInt(commands[i].split(" ")[1]);
            } else if(commands[i].equals("pop")) {
                if(cur == 0) {
                    System.out.println("-1");
                } else {
                    System.out.println(arr[cur--]);
                }
            } else if(commands[i].equals("size")) {
                System.out.println(cur);
            } else if(commands[i].equals("empty")) {
                if(cur == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(commands[i].equals("top")) {
                if(cur == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(arr[cur]);
                }
            }
        }

        br.close();
    }
}

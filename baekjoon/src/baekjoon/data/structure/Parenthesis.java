package baekjoon.data.structure;

import java.io.*;

public class Parenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }

        for(String str : arr) {
            if(isVPS(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        br.close();
    }

    public static boolean isVPS(String str) {
        char[] arr = str.toCharArray();
        int cursor = -1;

        boolean result = true;
        for(char c: arr) {
            if(c == '(') {
                arr[++cursor] = c;
            } else {
                if(cursor == -1) {
                    result = false;
                    break;
                }

                cursor--;
            }
        }

        if(cursor != -1) {
            result = false;
        }

        return result;
    }
}

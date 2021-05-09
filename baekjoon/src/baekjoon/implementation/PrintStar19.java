package baekjoon.implementation;

import java.io.*;

public class PrintStar19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int size = 4*N-3;
        char[][] matrix = new char[size][size];

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                matrix[i][j] = '*';
            }
        }

        int idx = 1;
        int whiteSize = size - 2;
        while(true) {
            if(whiteSize < 0) {
                break;
            }

            for(int i=0; i<whiteSize; i++) {
                matrix[idx][idx+i] = ' ';
                matrix[size-idx-1][idx+i] = ' ';
                matrix[idx+i][idx] = ' ';
                matrix[idx+i][size-idx-1] = ' ';
            }

            idx += 2;
            whiteSize -= 4;
        }

        for(int i=0; i<size; i++) {
            String str = new String(matrix[i]);
            bw.write(str + "\n");
        }

        bw.close();
        br.close();
    }
}

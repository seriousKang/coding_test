package baekjoon.implementation;

import java.io.*;
import java.util.*;

/**
 * #2563 색종이(https://www.acmicpc.net/problem/2563)
 */
public class ColorPaper {
    static int MAX_SIZE = 100;
    static int COLOR_PAPER_SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] matrix = new boolean[MAX_SIZE+1][MAX_SIZE+1];
        int N = Integer.valueOf(br.readLine());

        for(int i=0; i<N; i++) {
            String[] conditions = br.readLine().split(" ");
            int width = Integer.valueOf(conditions[0]);
            int height = Integer.valueOf(conditions[1]);

            for(int j=height; j<height+COLOR_PAPER_SIZE; j++) {
                for(int k=width; k<width+COLOR_PAPER_SIZE; k++) {
                    matrix[j][k] = true;
                }
            }
        }

        int result = 0;
        for(int i=1; i<=MAX_SIZE; i++) {
            for(int j=1; j<=MAX_SIZE; j++) {
                if(matrix[i][j]) result++;
            }
        }
        System.out.println(result);

        br.close();
    }
}

package baekjoon.dfs;

import java.io.*;
import java.util.*;

public class SafeArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[][] matrix = new int[N][N];

        int maxValue = 0;
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");

            for(int j=0; j<N; j++) {
                int value = Integer.valueOf(line[j]);
                matrix[i][j] = value;

                if(value > maxValue) {
                    maxValue = value;
                }
            }
        }
//        System.out.println(maxValue);

        int max = 0;
        for(int i=0; i<maxValue; i++) {
            boolean[][] tempMatrix = new boolean[N][N];

            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    if(matrix[j][k] > i) {
                        tempMatrix[j][k] = true;
                    }
                }
            }

            int result = search(N, tempMatrix);
            max = Math.max(result, max);
        }
        System.out.println(max);

        br.close();
    }

    public static int search(int N, boolean[][] matrix) {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(matrix[i][j] == true) {
                    cnt++;
                    dfs(j, i, N, matrix);
                }
            }
        }

        return cnt;
    }

    public static void dfs(int x, int y, int N, boolean[][] matrix) {
        matrix[y][x] = false;

        if(x+1<N && matrix[y][x+1]==true) {
            dfs(x+1, y, N, matrix);
        }
        if(x-1>=0 && matrix[y][x-1]==true) {
            dfs(x-1, y, N, matrix);
        }
        if(y+1<N && matrix[y+1][x]==true) {
            dfs(x, y+1, N, matrix);
        }
        if(y-1>=0 && matrix[y-1][x]==true) {
            dfs(x, y-1, N, matrix);
        }
    }
}

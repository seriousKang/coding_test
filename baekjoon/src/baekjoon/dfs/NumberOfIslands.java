package baekjoon.dfs;

import java.io.*;
import java.util.*;

public class NumberOfIslands {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> result = new ArrayList<>();
        while(true) {
            String size = br.readLine();
            int width = Integer.parseInt(size.split(" ")[0]);
            int height = Integer.parseInt(size.split(" ")[1]);

            if(width == 0 && height == 0) {
                break;
            }

            int[][] matrix = new int[height][width];
            for(int i=0; i<height; i++) {
                String[] elements = br.readLine().split(" ");

                for(int j=0; j<width; j++) {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                }
            }

            result.add(getNumberOfIslands(matrix));
        }

        for(int cnt: result) {
            System.out.println(cnt);
        }

        br.close();
    }

    public static int getNumberOfIslands(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        int cnt=0;
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(matrix[i][j] == 1) {
                    cnt++;
                    dfs(matrix, i, j);
                }
            }
        }

        return cnt;
    }

    public static void dfs(int[][] matrix, int y, int x) {
        int height = matrix.length;
        int width = matrix[0].length;
        matrix[y][x] = 0;

        if(y+1 <= height-1 && matrix[y+1][x] == 1) {
            dfs(matrix, y+1, x);
        }
        if(y+1 <= height-1 && x+1<=width-1 && matrix[y+1][x+1] == 1) {
            dfs(matrix, y+1, x+1);
        }
        if(x+1 <= width-1 && matrix[y][x+1] == 1) {
            dfs(matrix, y, x+1);
        }
        if(x+1 <= width-1 && y-1 >= 0 && matrix[y-1][x+1] == 1) {
            dfs(matrix, y-1, x+1);
        }
        if(y-1 >= 0 && matrix[y-1][x] == 1) {
            dfs(matrix, y-1, x);
        }
        if(y-1 >= 0 && x-1 >= 0 && matrix[y-1][x-1] == 1) {
            dfs(matrix, y-1, x-1);
        }
        if(x-1 >= 0 && matrix[y][x-1] == 1) {
            dfs(matrix, y, x-1);
        }
        if(x-1 >= 0 && y+1 <= height-1 && matrix[y+1][x-1] == 1) {
            dfs(matrix, y+1, x-1);
        }
    }
}

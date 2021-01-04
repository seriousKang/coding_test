package baekjoon.dfs;

import java.util.*;

public class OrganicCabbage {
    static int width;
    static int height;
    static int cabbageSize;
    static boolean[][] matrix;

    public static void dfs(int x, int y) {
        matrix[y][x] = false;

        if(y-1>=0 && matrix[y-1][x]) {
            dfs(x, y-1);
        }
        if(x+1<width && matrix[y][x+1]) {
            dfs(x+1, y);
        }
        if(y+1<height && matrix[y+1][x]) {
            dfs(x, y+1);
        }
        if(x-1>=0 && matrix[y][x-1]) {
            dfs(x-1, y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCaseSize = sc.nextInt();
        for(int i=0; i<testCaseSize; i++) {
            width = sc.nextInt();
            height = sc.nextInt();
            cabbageSize = sc.nextInt();

            matrix = new boolean[height][width];
            for(int j=0; j<cabbageSize; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                matrix[y][x] = true;
            }

            int cnt = 0;
            for(int y=0; y<height; y++) {
                for(int x=0; x<width; x++) {
                    if(matrix[y][x]) {
                        cnt++;
                        dfs(x, y);
                    }
                }
            }

            System.out.println(cnt);
        }

        sc.close();
    }
}

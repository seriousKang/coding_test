package baekjoon.dfs;

import java.util.*;

public class WarBattle {
    static int bluePower = 0;
    static int whitePower = 0;

    static char[][] matrix;
    static boolean[][] checked;
    static int width;
    static int height;

    public static int dfs(int y, int x, char c, int cnt) {
        if(y-1>=0 && !checked[y-1][x] && matrix[y-1][x] == c) {
            checked[y-1][x] = true;
            cnt = dfs(y-1, x, c, cnt+1);
        }
        if(x+1<width && !checked[y][x+1] && matrix[y][x+1] == c) {
            checked[y][x+1] = true;
            cnt = dfs(y, x+1, c, cnt+1);
        }
        if(y+1<height && !checked[y+1][x] && matrix[y+1][x] == c) {
            checked[y+1][x] = true;
            cnt = dfs(y+1, x, c, cnt+1);
        }
        if(x-1>=0 && !checked[y][x-1] && matrix[y][x-1] == c) {
            checked[y][x-1] = true;
            cnt = dfs(y, x-1, c, cnt+1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] matrixSize = sc.nextLine().split(" ");
        width = Integer.parseInt(matrixSize[0]);
        height = Integer.parseInt(matrixSize[1]);

        matrix = new char[height][width];
        checked = new boolean[height][width];

        for(int i=0; i<height; i++) {
            String line = sc.nextLine();
            matrix[i] = line.toCharArray();
        }

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(!checked[i][j]) {
                    checked[i][j] = true;
                    char c = matrix[i][j];
                    int power = dfs(i, j, c, 1);

                    if(c == 'W') {
                        whitePower += Math.pow(power, 2);
                    } else {
                        bluePower += Math.pow(power, 2);
                    }
                }
            }
        }
        System.out.printf("%d %d\n", whitePower, bluePower);

        sc.close();
    }
}
package baekjoon.dfs;

import java.util.*;

public class Virus {
    static int nodeSize;
    static int edgeSize;
    static boolean[][] matrix;
    static boolean[] visited;

    public static void dfs(int start) {
        for(int i=1; i<=nodeSize; i++) {
            if(!visited[i] && matrix[start][i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nodeSize = sc.nextInt();
        edgeSize = sc.nextInt();
        matrix = new boolean[nodeSize+1][nodeSize+1];
        visited = new boolean[nodeSize+1];

        for(int i=0; i<edgeSize; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            matrix[x][y] = true;
            matrix[y][x] = true;
        }

        visited[1] = true;
        dfs(1);

        int result = 0;
        for(int i=2; i<=nodeSize; i++) {
            if(visited[i]) result++;
        }
        System.out.println(result);

        sc.close();
    }
}

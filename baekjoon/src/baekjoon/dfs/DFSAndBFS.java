package baekjoon.dfs;

import java.util.*;

public class DFSAndBFS {
    static int vertexSize;
    static int edgeSize;
    static boolean[][] matrix;
    static boolean[] visited;

    public static void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex);

        for(int i=1; i<=vertexSize; i++) {
            if(!visited[i] && matrix[vertex][i]) {
                System.out.print(" ");
                dfs(i);
            }
        }
    }

    public static void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(startVertex);
        visited[startVertex] = true;
        System.out.print(startVertex);

        while(!queue.isEmpty()) {
            int vertex = queue.poll();

            for(int i=1; i<=vertexSize; i++) {
                if(!visited[i] && matrix[vertex][i]) {
                    visited[i] = true;
                    queue.offer(i);
                    System.out.print(" " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        vertexSize = sc.nextInt();
        edgeSize = sc.nextInt();
        int startVertex = sc.nextInt();

        matrix = new boolean[vertexSize+1][vertexSize+1];
        visited = new boolean[vertexSize+1];

        for(int i=1; i<=edgeSize; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            matrix[x][y] = true;
            matrix[y][x] = true;
        }

        dfs(startVertex);
        System.out.println();

        visited = new boolean[vertexSize+1];
        bfs(startVertex);

        sc.close();
    }
}

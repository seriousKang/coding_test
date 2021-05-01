package baekjoon.dfs;

import java.io.*;
import java.util.*;

public class NumberOfConnectedComponent {
    static int vertexSize;
    static int edgeSize;

    static boolean[][] matrix;
    static int[] connected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String graph = br.readLine();
        vertexSize = Integer.parseInt(graph.split(" ")[0]);
        edgeSize = Integer.parseInt(graph.split(" ")[1]);

        matrix = new boolean[vertexSize+1][vertexSize+1];
        connected = new int[vertexSize+1];

        for(int i=0; i<edgeSize; i++) {
            String edge = br.readLine();
            int start = Integer.parseInt(edge.split(" ")[0]);
            int end = Integer.parseInt(edge.split(" ")[1]);

            matrix[start][end] = true;
            matrix[end][start] = true;
        }

        for(int i=1; i<=vertexSize; i++) {
            if(connected[i] == 0) {
                connected[i] = i;
                dfs(i, i);
            }
        }
//        System.out.println(Arrays.toString(connected));

        Set result = new HashSet();
        for(int i=1; i<=vertexSize; i++) {
            result.add(connected[i]);
        }
//        System.out.println(result);
        System.out.println(result.size());

        br.close();
    }

    public static void dfs(int start, int targetVertex) {
        for(int i=1; i<=vertexSize; i++) {
            if(matrix[targetVertex][i] && connected[i] == 0) {
                connected[i] = start;
                dfs(start, i);
            }
        }
    }
}

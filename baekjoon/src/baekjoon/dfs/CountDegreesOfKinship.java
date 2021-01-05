package baekjoon.dfs;

import java.util.*;

public class CountDegreesOfKinship {
    static int personSize;
    static int p1;
    static int p2;
    static int relationSize;
    static boolean[][] matrix;

    public static int dfs(int start, int end, int cnt) {
        if(start == end) {
            return cnt;
        }

        int result = -1;
        for(int i=1; i<=personSize; i++) {
            if(matrix[start][i]) {
                matrix[start][i] = false;
                matrix[i][start] = false;

                int subResult = dfs(i, end, cnt+1);
                if(subResult != -1) {
                    result = subResult;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        personSize = sc.nextInt();
        matrix = new boolean[personSize+1][personSize+1];

        p1 = sc.nextInt();
        p2 = sc.nextInt();
        relationSize = sc.nextInt();

        for(int i=0; i<relationSize; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();

            matrix[parent][child] = true;
            matrix[child][parent] = true;
        }
        int result = dfs(p1, p2, 0);
        System.out.println(result);

        sc.close();
    }
}

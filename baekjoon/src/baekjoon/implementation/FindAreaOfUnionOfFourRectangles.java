package baekjoon.implementation;

import java.util.*;

public class FindAreaOfUnionOfFourRectangles {
    static int MATRIX_SIZE = 100;
    static int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<4; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            mark(x1, y1, x2, y2);
        }
//        for(int i=MATRIX_SIZE-1; i>=0; i--) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }

        for(int i=0; i<MATRIX_SIZE; i++) {
            for(int j=0; j<MATRIX_SIZE; j++) {
                if(matrix[i][j] == 1) result++;
            }
        }
        System.out.println(result);

        sc.close();
    }

    public static void mark(int x1, int y1, int x2, int y2) {
        for(int i=x1; i<x2; i++) {
            for(int j=y1; j<y2; j++) {
                matrix[j][i] = 1;
            }
        }
    }
}

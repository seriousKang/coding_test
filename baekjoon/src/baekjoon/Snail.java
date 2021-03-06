package baekjoon;

import java.util.*;

public class Snail {
    static int size;
    static int target;

    static int[][] matrix;
    static int targetX;
    static int targetY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        target = sc.nextInt();
        matrix = new int[size][size];

        setMatrix();
        showResult();

        sc.close();
    }

    public static void setMatrix() {
        int i=0;
        int j=0;
        int cnt=size*size;

        /**
         * 0 : south
         * 1 : east
         * 2 : north
         * 3 : west
         */
        int dir = 0;
        matrix[i][j] = cnt--;

        do {
            if(dir == 0) {
                if(i+1<size && matrix[i+1][j]==0) {
                    matrix[++i][j] = cnt--;
                } else {
                    dir = (dir + 1) % 4;
                }
            } else if(dir == 1) {
                if(j+1<size && matrix[i][j+1]==0) {
                    matrix[i][++j] = cnt--;
                } else {
                    dir = (dir + 1) % 4;
                }
            } else if(dir == 2) {
                if(i-1>=0 && matrix[i-1][j]==0) {
                    matrix[--i][j] = cnt--;
                } else {
                    dir = (dir + 1) % 4;
                }
            } else if(dir == 3) {
                if(j-1>=0 && matrix[i][j-1]==0) {
                    matrix[i][--j] = cnt--;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
        } while(cnt != 0);
    }

    public static void showResult() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                sb.append(matrix[i][j]);
                if(j!=size-1) {
                    sb.append(" ");
                }

                if(matrix[i][j] == target) {
                    targetX = i+1;
                    targetY = j+1;
                }
            }
            if(i!=size-1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
        System.out.printf("%d %d\n", targetX, targetY);
    }
}

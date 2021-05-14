package baekjoon.implementation;

import java.io.*;
import java.util.*;

/**
 * #16926 배열 돌리기 1(https://www.acmicpc.net/problem/16926)
 */
public class RotateArray1 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int height;
    static int width;
    static int rotateNum;
    static int[][] matrix;
    static int[][] targetMatrix;

    public static void main(String[] args) throws IOException {
        String[] conditions = br.readLine().split(" ");
//        System.out.println(Arrays.toString(conditions));

        height = Integer.valueOf(conditions[0]);
        width = Integer.valueOf(conditions[1]);
        rotateNum = Integer.valueOf(conditions[2]);
        matrix = new int[height][width];
        targetMatrix = new int[height][width];

        for(int i=0; i<height; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<width; j++) {
                matrix[i][j] = Integer.valueOf(line[j]);
            }
        }

        int min = Math.min(height, width);
        int rotateCoordinateSize;
        if(min % 2 == 0) {
            rotateCoordinateSize = min / 2;
        } else {
            rotateCoordinateSize = min / 2 + 1;
        }
//        System.out.println(rotateCoordinateSize);

        for(int cnt=0; cnt<rotateNum; cnt++) {
//            System.out.println(cnt + "/" + rotateNum);
            for (int i = 0; i < rotateCoordinateSize; i++) {
                int x = i;
                int y = i;
                int xLen = width - 2 * i;
                int yLen = height - 2 * i;
//                System.out.printf("%d, %d, %d, %d\n", x, y, xLen, yLen);
                rotate(x, y, xLen, yLen);
            }

//            printMatrix(targetMatrix);
            copyMatrix();
        }
        printMatrix(targetMatrix);

        br.close();
        bw.close();
    }

    public static void printMatrix(int[][] matrix) throws IOException {
        for(int i=0; i<height; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<width; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
        }
    }

    public static void copyMatrix() {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                matrix[i][j] = targetMatrix[i][j];
            }
        }
    }

    public static void rotate(int x, int y, int xLen, int yLen) {
//        int arrSize = xLen*2 + yLen*2 - 4;

        for(int i=0; i<yLen; i++) {
            if(i+1 < yLen) {
                targetMatrix[y+i+1][x] = matrix[y + i][x];
            } else {
                targetMatrix[y + yLen-1][x + 1] = matrix[y + i][x];
            }
        }

        for(int i=1; i<xLen; i++) {
            if(i+1 < xLen) {
                targetMatrix[y + yLen - 1][x + i + 1] = matrix[y + yLen - 1][x + i];
            } else {
                targetMatrix[y+yLen-2][x+xLen-1] = matrix[y+yLen-1][x+i];
            }
        }

        for(int i=1; i<yLen; i++) {
            if(i+1 < yLen) {
                targetMatrix[y + yLen -1 -i -1][x+xLen-1] = matrix[y + yLen -1 -i][x+xLen-1];
            } else {
                targetMatrix[y][x+xLen-2] = matrix[y + yLen -1 -i][x+xLen-1];
            }
        }

        for(int i=2; i<xLen; i++) {
            targetMatrix[y][x+xLen-1-i] = matrix[y][x+xLen-i];
        }
    }
}
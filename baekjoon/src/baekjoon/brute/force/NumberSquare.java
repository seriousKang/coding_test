package baekjoon.brute.force;

import java.io.*;
import java.util.*;

public class NumberSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] shape = br.readLine().split(" ");
        int height = Integer.parseInt(shape[0]);
        int width = Integer.parseInt(shape[1]);

        int[][] matrix = new int[height][width];
        for(int i=0; i<height; i++) {
            String str = br.readLine();
            for(int j=0; j<width; j++) {
                matrix[i][j] = Integer.valueOf(str.charAt(j) - '0');
            }
        }
//        for(int i=0; i<height; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }

        int maxLength = 1;
        for(int i=0; i<height-1; i++) {
            for(int j=0; j<width-1; j++) {
                int currentValue = matrix[i][j];

                int plus = maxLength;
                while(i+plus<height && j+plus<width) {
                    if(matrix[i+plus][j+plus] == currentValue &&
                       matrix[i+plus][j] == currentValue &&
                       matrix[i][j+plus] == currentValue) {
                        maxLength = Math.max(maxLength, plus+1);
                    }

                    plus++;
                }
            }
        }
        System.out.println((int)Math.pow(maxLength, 2));

        br.close();
    }
}

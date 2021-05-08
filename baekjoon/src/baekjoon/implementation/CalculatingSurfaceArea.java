package baekjoon.implementation;

import java.io.*;

public class CalculatingSurfaceArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] conditions = br.readLine().split(" ");
        int height = Integer.valueOf(conditions[0]);
        int width = Integer.valueOf(conditions[1]);
        int[][] shapes = new int[height][width];

        for(int i=0; i<height; i++) {
            String[] line = br.readLine().split(" ");

            for(int j=0; j<width; j++) {
                shapes[i][j] = Integer.valueOf(line[j]);
            }
        }

        int upSide = width * height * 2;
        int frontSide = 0;
        for(int i=0; i<width; i++) {
            int currentBlock = shapes[0][i];
            frontSide += currentBlock*2;

            for(int j=1; j<height; j++) {
                int nextBlock = shapes[j][i];
                if(currentBlock < nextBlock) {
                    frontSide += (nextBlock - currentBlock)*2;
                }
                currentBlock = nextBlock;
            }
        }

        int leftSide = 0;
        for(int i=0; i<height; i++) {
            int currentBlock = shapes[i][0];
            leftSide += currentBlock*2;

            for(int j=1; j<width; j++) {
                int nextBlock = shapes[i][j];
                if(currentBlock < nextBlock) {
                    leftSide += (nextBlock - currentBlock)*2;
                }
                currentBlock = nextBlock;
            }
        }
        System.out.println(upSide+leftSide+frontSide);

        br.close();
    }
}

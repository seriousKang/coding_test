package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * #7569 토마토(https://www.acmicpc.net/problem/7569)
 */
public class Tomato2 {
    static int[][][] BOX;
    static int WIDTH;
    static int HEIGHT;
    static int DEPTH;
    static Queue<Coordinate2> QUEUE = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] boxSize = br.readLine().split(" ");
        WIDTH = Integer.parseInt(boxSize[0]);
        HEIGHT = Integer.parseInt(boxSize[1]);
        DEPTH = Integer.parseInt(boxSize[2]);
        BOX = new int[DEPTH][HEIGHT][WIDTH];

        for(int i=0; i<DEPTH; i++) {
            for(int j=0; j<HEIGHT; j++) {
                String[] status = br.readLine().split(" ");

                for(int k=0; k<status.length; k++) {
                    BOX[i][j][k] = Integer.parseInt(status[k]);

                    if(BOX[i][j][k] == 1) {
                        QUEUE.offer(new Coordinate2(k, j, i, 1));
                    }
                }
            }
        }

        int maxDate = 0;
        while(!QUEUE.isEmpty()) {
            Coordinate2 coor = QUEUE.poll();

            int x = coor.x;
            int y = coor.y;
            int z = coor.z;
            int date = coor.date;
            maxDate = Math.max(maxDate, date-1);

            if(x+1 < WIDTH && BOX[z][y][x+1] == 0) {
                BOX[z][y][x+1] = date+1;
                Coordinate2 c = new Coordinate2(x+1, y, z, date+1);
                QUEUE.offer(c);
            }
            if(x-1 >= 0 && BOX[z][y][x-1] == 0) {
                BOX[z][y][x-1] = date+1;
                Coordinate2 c = new Coordinate2(x-1, y, z, date+1);
                QUEUE.offer(c);
            }
            if(y+1 < HEIGHT && BOX[z][y+1][x] == 0) {
                BOX[z][y+1][x] = date+1;
                Coordinate2 c = new Coordinate2(x, y+1, z, date+1);
                QUEUE.offer(c);
            }
            if(y-1 >= 0 && BOX[z][y-1][x] == 0) {
                BOX[z][y-1][x] = date+1;
                Coordinate2 c = new Coordinate2(x, y-1, z, date+1);
                QUEUE.offer(c);
            }
            if(z+1 < DEPTH && BOX[z+1][y][x] == 0) {
                BOX[z+1][y][x] = date+1;
                Coordinate2 c = new Coordinate2(x, y, z+1, date+1);
                QUEUE.offer(c);
            }
            if(z-1 >= 0 && BOX[z-1][y][x] == 0) {
                BOX[z-1][y][x] = date+1;
                Coordinate2 c = new Coordinate2(x, y, z-1, date+1);
                QUEUE.offer(c);
            }
        }

        if(isRemain()) {
            maxDate = -1;
        }
        System.out.println(maxDate);

        br.close();
    }

    public static boolean isRemain() {
        for(int i=0; i<DEPTH; i++) {
            for(int j=0; j<HEIGHT; j++) {
                for(int k=0; k<WIDTH; k++) {
                    if(BOX[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class Coordinate2 {
    int x;
    int y;
    int z;
    int date;

    public Coordinate2(int x, int y, int z, int date) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.date = date;
    }
}
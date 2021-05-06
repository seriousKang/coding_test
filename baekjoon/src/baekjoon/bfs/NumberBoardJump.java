package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * #2210 숫자판 점프(https://www.acmicpc.net/problem/2210)
 */
public class NumberBoardJump {
    static int BOARD_SIZE = 5;
    static String MATRIX[][] = new String[BOARD_SIZE][BOARD_SIZE];
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<BOARD_SIZE; i++) {
            String[] status = br.readLine().split(" ");
            MATRIX[i] = status;
        }

        for(int i=0; i<BOARD_SIZE; i++) {
            for(int j=0; j<BOARD_SIZE; j++) {
                search(j, i);
            }
        }
//        System.out.println(set);
        System.out.println(set.size());

        br.close();
    }

    public static void search(int x, int y) {
        Queue<Coordinate3> queue = new LinkedList<>();
        Coordinate3 c = new Coordinate3(x, y);
        c.addWord(MATRIX[y][x]);
        queue.offer(c);

        while(!queue.isEmpty()) {
            Coordinate3 currentC = queue.poll();
            if(currentC.composition.length() == 6) {
                set.add(currentC.composition.toString());
                continue;
            }

            int tempX = currentC.x;
            int tempY = currentC.y;
            String tempComposition = currentC.composition.toString();

            if(tempX+1<BOARD_SIZE) {
                Coordinate3 tempC = new Coordinate3(tempX+1, tempY);
                tempC.addWord(tempComposition);
                tempC.addWord(MATRIX[tempY][tempX+1]);
                queue.offer(tempC);
            }
            if(tempX-1>=0) {
                Coordinate3 tempC = new Coordinate3(tempX-1, tempY);
                tempC.addWord(tempComposition);
                tempC.addWord(MATRIX[tempY][tempX-1]);
                queue.offer(tempC);
            }
            if(tempY+1<BOARD_SIZE) {
                Coordinate3 tempC = new Coordinate3(tempX, tempY+1);
                tempC.addWord(tempComposition);
                tempC.addWord(MATRIX[tempY+1][tempX]);
                queue.offer(tempC);
            }
            if(tempY-1>=0) {
                Coordinate3 tempC = new Coordinate3(tempX, tempY-1);
                tempC.addWord(tempComposition);
                tempC.addWord(MATRIX[tempY-1][tempX]);
                queue.offer(tempC);
            }
        }
    }
}

class Coordinate3 {
    int x;
    int y;
    StringBuilder composition = new StringBuilder();

    public Coordinate3(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addWord(String word) {
        composition.append(word);
    }
}

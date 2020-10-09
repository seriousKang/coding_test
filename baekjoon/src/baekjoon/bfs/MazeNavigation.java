package baekjoon.bfs;

import java.util.*;

public class MazeNavigation {
    static int ROW;
    static int COLUMN;
    static char[][] MAZE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ROW = sc.nextInt();
        COLUMN = sc.nextInt();
        sc.nextLine();

        MAZE = new char[ROW][COLUMN];

        for(int i=0; i<ROW; i++) {
            String line = sc.nextLine();
            for(int j=0; j<COLUMN; j++) {
                MAZE[i][j] = line.charAt(j);
            }
        }
//        for(int i=0; i<ROW; i++) {
//            System.out.println(Arrays.toString(MAZE[i]));
//        }
        MAZE[0][0] = '0';
        Point startPoint = new Point(0, 0, 1);
        int result = bfs(startPoint);
        System.out.println(result);

        sc.close();
    }

    public static int bfs(Point startPoint) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(startPoint);
        int result = -1;

        while(!queue.isEmpty()) {
            Point curPoint = queue.poll();
            int curX = curPoint.getX();
            int curY = curPoint.getY();
            int curCnt = curPoint.getCnt();

            if(curX == ROW-1 && curY == COLUMN - 1) {
                result = curCnt;
                break;
            }

            if(validatePath(curX+1, curY)) {
                MAZE[curX+1][curY] = '0';
                queue.offer(new Point(curX+1, curY, curCnt+1));
            }
            if(validatePath(curX, curY+1)) {
                MAZE[curX][curY+1] = '0';
                queue.offer(new Point(curX, curY+1, curCnt+1));
            }
            if(validatePath(curX-1, curY)) {
                MAZE[curX-1][curY] = '0';
                queue.offer(new Point(curX-1, curY, curCnt+1));
            }
            if(validatePath(curX, curY-1)) {
                MAZE[curX][curY-1] = '0';
                queue.offer(new Point(curX, curY-1, curCnt+1));
            }
        }

        return result;
    }

    public static boolean validatePath(int x, int y) {
        if(x < 0 || y <0) return false;
        if(x >= ROW || y >= COLUMN) return false;
        if(MAZE[x][y] == '0') return false;

        return true;
    }
}

class Point {
    private int x;
    private int y;
    private int cnt;

    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCnt() {
        return cnt;
    }
}
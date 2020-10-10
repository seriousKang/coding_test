package baekjoon.bfs;

import java.util.*;

public class ComplexNumbering {
    static int N;
    static char[][] COORDINATE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        COORDINATE = new char[N][N];
        sc.nextLine();

        for(int i=0; i<N; i++) {
            String line = sc.nextLine();
            for(int j=0; j<line.length(); j++) {
                COORDINATE[i][j] = line.charAt(j);
            }
        }
//        for(int i=0; i<N; i++) {
//            System.out.println(COORDINATE[i]);
//        }

        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(COORDINATE[i][j] == '1') {
                    result.add(getComplexNum(i, j));
                }
            }
        }
        Collections.sort(result);

        System.out.println(result.size());
        for(int complexNum: result) {
            System.out.println(complexNum);
        }
    }

    public static boolean validatePath(int x, int y) {
        if(x<0 || y<0) return false;
        if(x>=N || y>=N) return false;
        if(COORDINATE[x][y] == '0') return false;

        return true;
    }

    public static int getComplexNum(int x, int y) {
        Queue<Point> queue = new LinkedList<Point>();

        int complexNum = 1;
        Point sPoint = new Point(x, y);
        COORDINATE[x][y] = '0';
        queue.offer(sPoint);

        while(!queue.isEmpty()) {
            Point curPoint = queue.poll();

            int curX = curPoint.getX();
            int curY = curPoint.getY();

            if(validatePath(curX+1, curY)) {
                queue.offer(new Point(curX+1, curY));
                COORDINATE[curX+1][curY] = '0';
                complexNum++;
            }
            if(validatePath(curX, curY+1)) {
                queue.offer(new Point(curX, curY+1));
                COORDINATE[curX][curY+1] = '0';
                complexNum++;
            }
            if(validatePath(curX-1, curY)) {
                queue.offer(new Point(curX-1, curY));
                COORDINATE[curX-1][curY] = '0';
                complexNum++;
            }
            if(validatePath(curX, curY-1)) {
                queue.offer(new Point(curX, curY-1));
                COORDINATE[curX][curY-1] = '0';
                complexNum++;
            }
        }

        return complexNum;
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
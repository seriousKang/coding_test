package baekjoon.bfs;

import java.util.*;

public class Tomato {
    static int M;
    static int N;
    static int[][] arr;
    static Queue<Coordinate> queue = new LinkedList<Coordinate>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 1) {
                    queue.offer(new Coordinate(j, i, 1));
                }
            }
        }

        int result = bfs();
        System.out.println(result);

        sc.close();
    }

    public static int bfs() {
        int result = 0;
        while(!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            int x = coordinate.getX();
            int y = coordinate.getY();
            int cnt = coordinate.getCnt();
            result = cnt;

            if (y-1 >= 0 && arr[y-1][x] == 0) {
                arr[y-1][x] = cnt + 1;
                queue.offer(new Coordinate(x, y - 1, cnt + 1));
            }
            if (x+1 < M && arr[y][x+1] == 0) {
                arr[y][x+1] = cnt + 1;
                queue.offer(new Coordinate(x + 1, y, cnt + 1));
            }
            if (y+1 < N && arr[y+1][x] == 0) {
                arr[y+1][x] = cnt + 1;
                queue.offer(new Coordinate(x, y + 1, cnt + 1));
            }
            if (x-1 >= 0 && arr[y][x-1] == 0) {
                arr[y][x-1] = cnt + 1;
                queue.offer(new Coordinate(x - 1, y, cnt + 1));
            }
        }

        if(isComplete()) {
            return result-1;
        } else {
            return -1;
        }
    }

    public static boolean isComplete() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0)
                    return false;
            }
        }

        return true;
    }
}

class Coordinate {
    private int x;
    private int y;
    private int cnt;

    public Coordinate(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}

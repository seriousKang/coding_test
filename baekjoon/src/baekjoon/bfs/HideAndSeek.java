package baekjoon.bfs;

import java.util.*;

/**
 * #1697 숨바꼭질(https://www.acmicpc.net/problem/1697)
 */
public class HideAndSeek {
    static Queue<Position> queue = new LinkedList<>();
    static int MAX_POSITION = 100000;
    static boolean[] visited = new boolean[MAX_POSITION+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Position position = new Position(N, 0);
        visited[N] = true;
        queue.offer(position);

        int result = bfs(K);
        System.out.println(result);

        sc.close();
    }

    public static int bfs(int target) {
        int result = 0;
        while(!queue.isEmpty()) {
            Position position = queue.poll();
            int currentPosition = position.currentPosition;
            int cnt = position.cnt;

            if(currentPosition == target) {
                result = cnt;
                break;
            }

            if(currentPosition*2 <= MAX_POSITION && visited[currentPosition*2] == false) {
                visited[currentPosition*2] = true;
                queue.offer(new Position(currentPosition*2, cnt+1));
            }
            if(currentPosition+1 <= MAX_POSITION && visited[currentPosition+1] == false) {
                visited[currentPosition+1] = true;
                queue.offer(new Position(currentPosition+1, cnt+1));
            }
            if(currentPosition-1 >= 0 && visited[currentPosition-1] == false) {
                visited[currentPosition-1] = true;
                queue.offer(new Position(currentPosition-1, cnt+1));
            }
        }

        return result;
    }
}

class Position {
    int currentPosition;
    int cnt;

    Position(int currentPosition, int cnt) {
        this.currentPosition = currentPosition;
        this.cnt = cnt;
    }
}
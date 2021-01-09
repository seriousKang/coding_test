package programmers.lv3.bfs.dfs;

public class Network {
    boolean[] checked;
    int nodeSize;
    int[][] nodes;

    public void dfs(int start) {
        for(int i=0; i<nodeSize; i++) {
            if(start == i)
                continue;

            if(nodes[start][i] == 1 && !checked[i]) {
                checked[i] = true;
                dfs(i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        checked = new boolean[n];
        nodeSize = n;
        nodes = computers;

        int result = 0;
        for(int i=0; i<n; i++) {
            if(!checked[i]) {
                checked[i] = true;
                result++;
                dfs(i);
            }
        }

        return result;
    }
}

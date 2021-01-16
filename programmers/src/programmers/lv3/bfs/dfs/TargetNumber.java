package programmers.lv3.bfs.dfs;

public class TargetNumber {
    int result = 0;

    public void dfs(boolean isPlus, int cursor, int[] numbers, int subSum, int target) {
        if(isPlus) {
            subSum += numbers[cursor];
        } else {
            subSum -= numbers[cursor];
        }

        if(cursor == numbers.length-1) {
            if(subSum == target)
                result++;
        } else {
            dfs(true, cursor+1, numbers, subSum, target);
            dfs(false, cursor+1, numbers, subSum, target);
        }
    }

    public int solution(int[] numbers, int target) {
        dfs(true, 0, numbers, 0, target);
        dfs(false, 0, numbers, 0, target);
        System.out.println(result);

        return result;
    }
}

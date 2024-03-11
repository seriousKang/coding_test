package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * time complexity: O(N)
 * space complexity: O(N)
 */
public class P682 {
    public int calPoints(String[] operations) {
        Deque<Integer> scores = new ArrayDeque<>();

        for(String operation: operations) {
            if(operation.equals("+")) {
                int lastScore = scores.pop();
                int lastPreviousScore = scores.pop();

                scores.push(lastPreviousScore);
                scores.push(lastScore);
                scores.push(lastPreviousScore + lastScore);
            } else if(operation.equals("D")) {
                int lastScore = scores.pop();

                scores.push(lastScore);
                scores.push(lastScore * 2);
            } else if(operation.equals("C")) {
                scores.pop();
            } else {
                scores.push(Integer.valueOf(operation));
            }
        }

        int sum = 0;
        while(!scores.isEmpty()) {
            sum += scores.pop();
        }

        return sum;
    }
}
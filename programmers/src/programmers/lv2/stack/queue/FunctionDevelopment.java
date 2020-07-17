package programmers.lv2.stack.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {
	public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> answerList = new ArrayList<Integer>();
        
        for(int i=0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            int devPeriod;
            
            if(remain%speeds[i] == 0) {
                devPeriod = remain / speeds[i];
            } else {
                devPeriod = remain / speeds[i] + 1;
            }
            
            if(!queue.isEmpty() && devPeriod > queue.peek()) { 
                answerList.add(queue.size());
                queue.clear();
            }
            
            queue.offer(devPeriod);
        }
        answerList.add(queue.size());
        
        int[] answerArr = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answerArr[i] = answerList.get(i);
        }
        
        return answerArr;
    }
}

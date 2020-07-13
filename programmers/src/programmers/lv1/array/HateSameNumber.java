package programmers.lv1.array;

import java.util.ArrayList;
import java.util.List;

public class HateSameNumber {
	public int[] solution(int []arr) {
        List list = new ArrayList<>();
        
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            int temp = (int)list.get(list.size() - 1);
            
            if(temp != arr[i]) {
                list.add(arr[i]);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = (int)list.get(i);
        }
        
        return answer;
    }
}

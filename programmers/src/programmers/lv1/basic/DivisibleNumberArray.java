package programmers.lv1.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisibleNumberArray {
	public int[] solution(int[] arr, int divisor) {
        int[] answer = {-1};
        
        List list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        
        if(list.size() != 0) {
            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++) {
                answer[i] = (int)list.get(i);
            }
            Arrays.sort(answer);
        }
        
        return answer;
    }
}

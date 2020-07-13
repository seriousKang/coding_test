package programmers.lv1.basic;

import java.util.ArrayList;
import java.util.List;

public class RemoveSmallestNumber {
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 5};
		
		for(int value: solution(arr)) {
			System.out.println(value);
		}
	}
	
	public static int[] solution(int[] arr) {
		int smallest = Integer.MAX_VALUE;
        List list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            list.add(arr[i]);
            
            if(arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        
        list.remove(Integer.valueOf(smallest));
        if(list.size() == 0) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = (int)list.get(i);
        }
        return answer;
    }
}

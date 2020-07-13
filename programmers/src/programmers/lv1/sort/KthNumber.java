package programmers.lv1.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthNumber {
	public int[] solution(int[] array, int[][] commands) {
        int subArrSize = commands.length;
        int[] answer = new int[subArrSize];
        
        for(int i=0; i<subArrSize; i++) {
            int[] subArr = commands[i];
            List list = new ArrayList<>();
            
            int start = subArr[0]-1;
            int end = subArr[1];
            int k = subArr[2]-1;
            for(int j=start; j<end; j++) {
                list.add(array[j]);
            }
            
            answer[i] = getKNum(list, k);
        }
        
        return answer;
    }
    
    public int getKNum(List list, int k) {
        Collections.sort(list);
        return (int)list.get(k);
    }
}

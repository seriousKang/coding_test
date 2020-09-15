package programmers.lv1.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PickTwoAndAdd {
	public int[] solution(int[] numbers) {
        Set<Integer> sumSet = new HashSet<Integer>();
        
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                sumSet.add(sum);
            }
        }
        // System.out.println("sumSet:" + sumSet);
        
        int[] result = new int[sumSet.size()];
        int idx = 0;
        for(int sum: sumSet) {
            result[idx++] = sum;
        }
        Arrays.sort(result);
        
        return result;
    }
}

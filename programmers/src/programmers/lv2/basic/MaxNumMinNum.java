package programmers.lv2.basic;

import java.util.Arrays;

public class MaxNumMinNum {
	public String solution(String s) {
        String[] arr = s.split(" ");
        int[] intArr = new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            intArr[i] = Integer.valueOf(arr[i]);
        }
        Arrays.sort(intArr);
        //System.out.println(Arrays.toString(intArr));
        
        int min = intArr[0];
        int max = intArr[intArr.length-1];
        
        return String.format("%d %d", min, max);
    }
}

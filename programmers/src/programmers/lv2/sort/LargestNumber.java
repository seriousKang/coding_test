package programmers.lv2.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String solution(int[] numbers) {
        String[] strNumArr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            strNumArr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumArr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        // System.out.println(Arrays.toString(strNumArr));
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strNumArr.length; i++) {
            sb.append(strNumArr[i]);
        }
        
        String result = sb.toString();
        return result.charAt(0)=='0' ? "0":result;
    }
}

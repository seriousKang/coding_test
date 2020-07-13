package programmers.lv1.basic;

import java.util.Arrays;

public class IntegerDescendingOrder {
	public long solution(long n) {
        String str = String.valueOf(n);
        char[] cArr = str.toCharArray();
        
        Arrays.sort(cArr);
        String sortStr = String.valueOf(cArr);
        StringBuilder sb = new StringBuilder(sortStr);
        
        return Long.valueOf(sb.reverse().toString());
    }
}

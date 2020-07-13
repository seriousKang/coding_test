package programmers.lv1.basic;

public class HarshadNumber {
	public boolean solution(int x) {
        String[] cArr = String.valueOf(x).split("");
        
        int sum = 0;
        for(int i=0; i<cArr.length; i++) {
            sum += Integer.valueOf(cArr[i]);
        }
        
        boolean result = false;
        if(x % sum == 0) result = true;
        
        return result;
    }
}

package programmers.lv1.string;

public class GetMiddleLetter {
    public String solution(String s) {
    	String answer = "";
        
        int strLen = s.length();
        
        if(strLen%2 == 0) {
            /* even */
            int midIdx = strLen / 2 - 1;
            answer = s.substring(midIdx, midIdx+2);
        } else {
            /* odd */
            int midIdx = strLen / 2;
            answer = s.substring(midIdx, midIdx+1);
        }
        
        return answer;
    }
}

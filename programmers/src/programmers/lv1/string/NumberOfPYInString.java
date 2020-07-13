package programmers.lv1.string;

public class NumberOfPYInString {
	boolean solution(String s) {
		boolean answer = true;
        int yCnt = 0;
        int pCnt = 0;
        
        for(int i=0; i<s.length(); i++) {
            char tempChar = s.charAt(i);
            
            if(tempChar == 'p' || tempChar == 'P') {
                pCnt++;
            } else if(tempChar == 'y' || tempChar == 'Y') {
                yCnt++;
            }
        }
        
        if(yCnt != pCnt) {
            answer = false;
        }

        return answer;
    }
}

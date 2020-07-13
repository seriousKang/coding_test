package programmers.lv1.basic;

public class FindKimInSeoul {
	public String solution(String[] seoul) {
        String answer = "";
        
        int targetIdx = 0;
        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                targetIdx = i;
                break;
            }
        }
        
        answer = String.format("김서방은 %d에 있다", targetIdx);
        return answer;
    }
}

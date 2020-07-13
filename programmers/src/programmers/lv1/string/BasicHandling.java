package programmers.lv1.string;

public class BasicHandling {
	public boolean solution(String s) {
		boolean answer = true;
        
        if(s.length() != 4 && s.length() != 6) {
            System.out.println(s + " length:" + s.length());
            answer = false;
        } else {
            try {
                Integer.valueOf(s);
            } catch(Exception e) { 
                System.out.println(s + " is not number");
                answer = false;
            }
        }
        
        return answer;
    }
}
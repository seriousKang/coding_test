package programmers.lv2.hash;

public class PhoneNumberList {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i=0; i<phone_book.length-1; i++) {
            String currentStr = phone_book[i];
            
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[j].startsWith(currentStr) || currentStr.startsWith(phone_book[j])) {
                    answer = false;
                    break;
                }
            }
            
            if(answer == false) {
                break;
            }
        }
        
        return answer;
    }
}

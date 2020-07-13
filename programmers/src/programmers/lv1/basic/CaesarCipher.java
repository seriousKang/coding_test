package programmers.lv1.basic;

public class CaesarCipher {
	public String solution(String s, int n) {
        final int ALPHA_LEN = 26;

        char[] cArr = s.toCharArray();
        for(int i=0; i<cArr.length; i++) {
            char tempChar = cArr[i];
            
            if(cArr[i] == ' ') continue;
            
            if(Character.isUpperCase(cArr[i])) {
                tempChar -= 'A';
            } else {
                tempChar -= 'a';
            }
            
            tempChar += n;
            tempChar %= ALPHA_LEN;
            
            if(Character.isUpperCase(cArr[i])) {
                tempChar += 'A';
            } else {
                tempChar += 'a';
            }
            
            cArr[i] = tempChar;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cArr.length; i++) {
            sb.append(cArr[i]);
        }
        
        return sb.toString();
    }
}

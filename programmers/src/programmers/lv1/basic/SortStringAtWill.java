package programmers.lv1.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SortStringAtWill {
	public String[] solution(String[] strings, int n) {
        char[] nChar = new char[strings.length];
        for(int i=0; i<strings.length; i++) {
            nChar[i] = strings[i].charAt(n);
        }
        Arrays.sort(nChar);
        
        Set charSet = new LinkedHashSet<>();
        for(int i=0; i<nChar.length; i++) {
            charSet.add(nChar[i]);
        }
        
        List answerList = new ArrayList();
        for(Object charObj: charSet) {
            List list = new ArrayList();
            
            for(int i=0; i<strings.length; i++) {
                if(strings[i].charAt(n) == (char)charObj) {
                    list.add(strings[i]);
                }
            }
            Collections.sort(list);
            
            for(Object sortedStr: list) {
                answerList.add(sortedStr);
            }
        }
        
        String[] answer = new String[strings.length];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i).toString();
        }
        
        return answer;
    }
}

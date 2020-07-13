package programmers.lv2.hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
	public int solution(String[][] clothes) {
        Map map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            String clothesType = clothes[i][1];
            
            if(!map.containsKey(clothesType)) { 
                map.put(clothesType, 1);
            } else {
                int clothesNum = (int)map.get(clothesType);
                map.put(clothesType, clothesNum+1);
            }
        }
        
        int caseNum = 1;
        for(Object key: map.keySet()) {
            int clothesNum = (int)map.get(key);
            caseNum *= (clothesNum+1);
        }
        
        return caseNum-1;
    }
}

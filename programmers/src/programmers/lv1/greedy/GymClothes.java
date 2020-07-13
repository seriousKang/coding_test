package programmers.lv1.greedy;

import java.util.ArrayList;
import java.util.List;

public class GymClothes {
	public int solution(int n, int[] lost, int[] reserve) {
        int[] gymClothArr = new int[n];
        
        for(int i=0; i<n; i++) {
            gymClothArr[i] = 1;                
        }
        
        for(int i=0; i<lost.length; i++) {
            int lostNum = lost[i] - 1;    
            gymClothArr[lostNum] = 0;
        }
        
        List reserveList = new ArrayList<>();
        for(int i=0; i<reserve.length; i++) {
            int reserveNum = reserve[i];
            
            if(gymClothArr[reserveNum-1] == 0) {
                gymClothArr[reserveNum-1] = 1;
                continue;
            }
            
            reserveList.add(reserveNum);
        }
        
        for(int i=0; i<reserveList.size(); i++) {
            int reserveNum = (int)reserveList.get(i)-1;
            
            if(reserveNum-1 >= 0 && gymClothArr[reserveNum-1] == 0) {
                gymClothArr[reserveNum-1] = 1;
            } else if(reserveNum+1 <= n-1 && gymClothArr[reserveNum+1] == 0) {
                gymClothArr[reserveNum+1] = 1;
            }
        }
        
        int cnt=0;
        for(int i=0; i<n; i++) {
            if(gymClothArr[i] == 1) cnt++;
        }
        
        return cnt;
    }
}

package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answer = new ArrayList<Boolean>();
        
        int greatestNum = -1;
        for(int i=0; i<candies.length; i++) {
            if(greatestNum < candies[i]) {
                greatestNum = candies[i];
            }
        }
        
        for(int i=0; i<candies.length; i++) {
            if(candies[i]+extraCandies >= greatestNum) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }
        // System.out.println("answer:" + answer);
        
        return answer;
    }
}

package leetcode.easy;

public class ThreeConsecutiveOdds {
	public boolean threeConsecutiveOdds(int[] arr) {
        int oddsCnt=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%2 != 0) {
                oddsCnt++;
            } else {
                oddsCnt=0;
            }
            
            if(oddsCnt == 3) {
                return true;
            }
        }
        return false;
    }
}

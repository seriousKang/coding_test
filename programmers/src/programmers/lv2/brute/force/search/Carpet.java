package programmers.lv2.brute.force.search;

public class Carpet {
	public int[] solution(int brown, int yellow) {
        int sumXY = (brown+4)/2;
        int multiplyXY = brown+yellow;
        // System.out.printf("sum:%d, multiply:%d", sumXY, multiplyXY);
        
        int tempX = 1;
        int tempY = multiplyXY;
        int[] answer = new int[2];
        while(tempX < tempY) {
            if(multiplyXY % tempX == 0) {
                tempY = multiplyXY / tempX;
                // System.out.printf("%d, %d:%s\n", tempX, tempY, validateSumXY(sumXY, tempX, tempY));
                if(validateSumXY(sumXY, tempX, tempY)) {
                    answer[0] = tempY;
                    answer[1] = tempX;
                }
            }
            
            tempX++;
        }
        
        return answer;
    }
    
    public boolean validateSumXY(int sumXY, int x, int y) {
        return (sumXY == (x+y)) ? true : false;
    }
}

package programmers.lv1.basic;

public class IntegerSquareRootDiscrimination {
	public long solution(long n) {
        long answer = 0;
        
        long squareRoot = 1;
        while(true) {
            if(squareRoot*squareRoot == n) {
                break;
            } else if(squareRoot*squareRoot > n) {
                answer = -1;
                break;
            }
            
            squareRoot++;
        }
        
        if(answer != -1)
            answer = (squareRoot+1)*(squareRoot+1);
            
        return answer;
    }
}

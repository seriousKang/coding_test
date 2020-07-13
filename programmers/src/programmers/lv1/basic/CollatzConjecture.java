package programmers.lv1.basic;

public class CollatzConjecture {
	public static void main(String[] args) {
		System.out.println(solution(626331));
	}
	
	public static int solution(long num) {
        final int LIMIT_CNT = 500;
        
        int cnt = -1;
        for(int i=0; i<=LIMIT_CNT; i++) {
            if(num == 1) {
                cnt = i;
                break;
            }
            
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num = num*3 + 1;
            }
        }
        
        return cnt;
    }
}

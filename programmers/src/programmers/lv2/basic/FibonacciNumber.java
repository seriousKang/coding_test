package programmers.lv2.basic;

public class FibonacciNumber {
	public int solution(int n) {
        return fibonacci(n);
    }
    
    public int fibonacci(int n) {
        int[] fiboArr = new int[n+1];
        final int DIVISION = 1234567;
        
        for(int i=0; i<=n; i++) {
            if(i<=1) {
                fiboArr[i] = i;
            } else {
                fiboArr[i] = (fiboArr[i-1] + fiboArr[i-2]) % DIVISION;
            }
        }
        
        return fiboArr[n];
    }

	/*
	 *  recursive
	 *    - time error
	 */
//	public int fibonacci(int n) {
//        if(n <= 1) {
//            return n;
//        } else {
//            return fibonacci(n-2) + fibonacci(n-1);
//        }
//    }
}

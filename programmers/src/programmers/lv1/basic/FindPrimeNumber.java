package programmers.lv1.basic;

public class FindPrimeNumber {
	public int solution(int n) {
        int[] arr = new int[n+1];
            
        for(int i=2; i<=n; i++) {
            arr[i] = 1;
        }
        
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(arr[i] == 0)
                continue;
            
            int j=2;
            while(true) {
                int remove = i*j;
                
                if(remove > n)
                    break;
                
                arr[remove] = 0;
                j++;
            }
        }
        // System.out.println(Arrays.toString(arr));
        
        int sum=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) sum++;
        }
        return sum;
    }
}

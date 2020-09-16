package leetcode.easy;

public class FindNUniqueIntegersSumUpToZero {
	public int[] sumZero(int n) {
        int[] result = new int[n];
        
        int idx=0;
        for(int i=-(n/2); i<=n/2; i++) {
            if(n%2==0 && i==0) continue;
                
            result[idx++] = i;
        }
        // System.out.println("result:" + Arrays.toString(result));

        return result;
    }
}

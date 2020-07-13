package programmers.lv1.basic;

public class MakeArrayWithInverseInteger {
	public int[] solution(long n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder(str);
        String reverseStr = sb.reverse().toString();
        // System.out.println(reverseStr);
        
        int[] arr = new int[reverseStr.length()];
        for(int i=0; i<reverseStr.length(); i++) {
            arr[i] = reverseStr.charAt(i) - '0';
        }
        // System.out.println(Arrays.toString(arr));
        
        return arr;
    }
}

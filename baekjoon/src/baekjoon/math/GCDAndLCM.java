package baekjoon.math;

import java.util.*;

public class GCDAndLCM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[2];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		List<Integer> divisorList = new ArrayList<Integer>();
		for(int i=2; i<=arr[0]; i++) {
			if(isDivisible(arr, i)) {
				divisorList.add(i);
				
				for(int j=0; j<arr.length; j++) {
					arr[j] = arr[j] / i;
				}
				
				i=1;
			}
		}
		
		//GCD
		int result=1;
		for(int value: divisorList) {
			result *= value;
		}
		System.out.println(result);
		
		//LCM
		for(int value: arr) {
			result *= value;
		}
		System.out.println(result);
		
		sc.close();
	}
	
	public static boolean isDivisible(int[] arr, int divisor) {
		for(int value: arr) {
			if(value % divisor != 0)
				return false;
		}
		
		return true;
	}
}

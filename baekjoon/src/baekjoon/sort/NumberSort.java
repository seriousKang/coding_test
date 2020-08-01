package baekjoon.sort;

import java.util.*;

public class NumberSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numSize = sc.nextInt();
		int[] numArr = new int[numSize];
		for(int i=0; i<numSize; i++) {
			numArr[i] = sc.nextInt();
		}
		
		Arrays.sort(numArr);
//		System.out.println(Arrays.toString(numArr));
		for(int i=0; i<numSize; i++) {
			System.out.println(numArr[i]);
		}
		
		sc.close();
	}
}

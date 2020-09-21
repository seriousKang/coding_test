package baekjoon.greedy;

import java.util.*;

public class Rope {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[] ropeArr = new Integer[N];
		
		for(int i=0; i<N; i++) {
			ropeArr[i] = sc.nextInt();
		}
		Arrays.sort(ropeArr, Comparator.reverseOrder());
//		System.out.println("ropeArr:" + Arrays.toString(ropeArr));
		
		int max=0;
		for(int i=0; i<N; i++) {
			int temp = ropeArr[i] * (i+1);
			
			if(temp > max) {
				max = temp;
			}
		}
		
		System.out.println(max);
		sc.close();
	}
}

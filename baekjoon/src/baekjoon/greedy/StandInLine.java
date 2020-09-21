package baekjoon.greedy;

import java.util.*;

public class StandInLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
//		System.out.println("arr:" + Arrays.toString(arr));
		
		int[] result = new int[N];
		for(int i=0; i<N; i++) {
			int current = arr[i];
			
			for(int j=0, cnt=0; j<N; j++) {
				if(result[j] == 0) cnt++;
				
				if(current+1 == cnt) {
					result[j] = i+1;
					break;
				}
			}
		}
//		System.out.println("result:" + Arrays.toString(result));
		
		for(int i=0; i<N; i++) {
			System.out.printf("%d ", result[i]);
		}
	}
}

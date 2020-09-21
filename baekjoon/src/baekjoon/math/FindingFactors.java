package baekjoon.math;

import java.util.*;

public class FindingFactors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int result=0;
		for(int i=1, cnt=0; i<=N; i++) {
			if(N%i == 0) cnt++;
			
			if(cnt == K) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		sc.close();
	}
}

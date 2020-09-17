package baekjoon.greedy;

import java.util.*;

public class SugarDelivery {
	public static void main(String[] args) {
		final int FIVE = 5;
		final int THREE = 3;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = -1;
		
		for(int i=n/FIVE; i>=0; i--) {
			int packageCnt = i;
			int remain = n - i*FIVE;
			
			if(remain == 0) result = packageCnt;
			
			for(int j=remain/THREE; j>0; j--) {
				int subRemain = remain - j*THREE;
				
				if(subRemain == 0) {
					packageCnt += j;
					result = packageCnt;
					break;
				}
			}
			
			if(result != -1) break;
		}
		System.out.println(result);
	}
}

package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int personNum = sc.nextInt();
		int[] withdrawlTime = new int[personNum];
		
		for(int i=0; i<personNum; i++) {
			withdrawlTime[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(withdrawlTime);
//		System.out.println(Arrays.toString(withdrawlTime));
		
		int withdrawlTimeSum = 0;
		for(int i=0; i<personNum; i++) {
			int currentWithdrawlTime=0;
			
			for(int j=0; j<=i; j++) {
				currentWithdrawlTime += withdrawlTime[j]; 
			}
			withdrawlTimeSum += currentWithdrawlTime;
		}
		
		System.out.println(withdrawlTimeSum);
	}
}

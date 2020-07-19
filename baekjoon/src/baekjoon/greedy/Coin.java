package baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Coin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int coinNum = sc.nextInt();
		int targetValue = sc.nextInt();
		Integer[] arr = new Integer[coinNum];
		
		for(int i=0; i<coinNum; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr, Comparator.reverseOrder());
//		System.out.println(Arrays.toString(arr));
		
		int coinCnt=0;
		for(int i=0; i<coinNum; i++) {
			if(targetValue == 0)
				break;
			
			int currentCoin = arr[i];
			if(targetValue >= currentCoin) {
				int currentCoinCnt = targetValue/currentCoin;
				targetValue = targetValue % currentCoin;
				coinCnt += currentCoinCnt;
			}
		}
		System.out.println(coinCnt);
	}
}

package baekjoon.greedy;

import java.util.*;

public class Change {
	public static void main(String[] args) {
		final int RECEIVED_MONEY = 1000;
		final int[] CHANGE_COIN = {500, 100, 50, 10, 5, 1};
		
		Scanner sc = new Scanner(System.in);
		int change = RECEIVED_MONEY - sc.nextInt();
//		System.out.println("change:" + change);
		
		int result = 0;
		for(int i=0; i<CHANGE_COIN.length; i++) {
			result += change / CHANGE_COIN[i];
			change = change % CHANGE_COIN[i];
		}
		System.out.println(result);
	}
}

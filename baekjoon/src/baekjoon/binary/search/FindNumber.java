package baekjoon.binary.search;

import java.util.Arrays;
import java.util.Scanner;

public class FindNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int foundNumSize = sc.nextInt();
		int[] foundNumArr = new int[foundNumSize];
		for(int i=0; i<foundNumSize; i++) {
			foundNumArr[i] = sc.nextInt();
		}
		Arrays.sort(foundNumArr);
//		System.out.println(Arrays.toString(foundNumArr));
		
		int findNumSize = sc.nextInt();
		int[] findNumArr = new int[findNumSize];
		for(int i=0; i<findNumSize; i++) {
			findNumArr[i] = sc.nextInt();
		}
		sc.close();
		
		for(int i=0; i<findNumSize; i++) {
			System.out.println(findNum(foundNumArr, findNumArr[i]));
		}
	}
	
	public static int findNum(int[] foundNumArr, int findNum) {
		int sIdx = 0;
		int eIdx = foundNumArr.length-1;
		int found = 0;
		
		while(sIdx <= eIdx) {
			int mIdx = (sIdx+eIdx)/2;
			int targetValue = foundNumArr[mIdx];
			
			if(findNum == targetValue) {
				found = 1;
				break;
			} else if(findNum > targetValue) {
				sIdx = mIdx + 1;
			} else if(findNum < targetValue) {
				eIdx = mIdx - 1;
			}
		}
		
		return found;
	}
}

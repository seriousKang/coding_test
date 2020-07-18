package baekjoon.one.dimension.array;

import java.util.Arrays;
import java.util.Scanner;

public class MinMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numSize = sc.nextInt();
		int[] arr = new int[numSize];
		for(int i=0; i<numSize; i++) {
			arr[i] = sc.nextInt();
		}
//		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		
		System.out.println(String.format("%d %d", arr[0], arr[numSize-1]));
		sc.close();
	}
}

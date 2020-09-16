package baekjoon.sort;

import java.util.*;

public class SortInside {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		Integer[] arr = new Integer[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.charAt(i) - '0';
		}
		Arrays.sort(arr, Comparator.reverseOrder());
//		System.out.println("arr:" + Arrays.toString(arr));
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb.toString());
	}
}

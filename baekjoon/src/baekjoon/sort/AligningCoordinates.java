package baekjoon.sort;

import java.io.*;
import java.util.*;

public class AligningCoordinates {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int coordinatesNum = Integer.parseInt(br.readLine());
		String[] coordinatesArr = new String[coordinatesNum];
		
		for(int i=0; i<coordinatesNum; i++) {
			coordinatesArr[i] = br.readLine();
		}
//		System.out.println("coordinatesArr:" + Arrays.toString(coordinatesArr));
		
		Arrays.sort(coordinatesArr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int x1 = Integer.parseInt(s1.split(" ")[0]);
				int y1 = Integer.parseInt(s1.split(" ")[1]);
				int x2 = Integer.parseInt(s2.split(" ")[0]);
				int y2 = Integer.parseInt(s2.split(" ")[1]);
				
				if(x1 > x2) return 1;
				else if(x1 < x2) return -1;
				
				if(y1 > y2) return 1;
				else if(y1 < y2) return -1;
				
				return 0;
			}
		});
//		System.out.println("coordinatesArr:" + Arrays.toString(coordinatesArr));
		
		for(int i=0; i<coordinatesNum; i++) {
			System.out.println(coordinatesArr[i]);
		}
	}
}

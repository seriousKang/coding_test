package baekjoon.binary.search;

import java.util.*;
import java.io.*;

/*
 * - 시간초과 원인: 결과를 하나씩 출력시켰을 때 시간 초과
 * - 해결 방안: StringBuilder에 저장하고 한번에 출력하는 방식으로 변경
 */
public class NumberCard {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int srcCardNum = Integer.parseInt(br.readLine());
		String[] srcCardStrArr = br.readLine().split(" "); 
		int[] srcCardArr = new int[srcCardNum];
		
		for(int i=0; i<srcCardNum; i++) {
			srcCardArr[i] = Integer.parseInt(srcCardStrArr[i]);
		}
		Arrays.sort(srcCardArr);
//		System.out.println("srcCardArr:" + Arrays.toString(srcCardArr));
		
		int comparedCardNum = Integer.parseInt(br.readLine());
		String[] comparedCardStrArr = br.readLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<comparedCardNum; i++) {
			int comparedValue = Integer.parseInt(comparedCardStrArr[i]);

			boolean result = search(srcCardArr, comparedValue);
			int resultValue = result ? 1 : 0;
			sb.append(resultValue + " ");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean search(int[] srcArr, int targetValue) {
		int sIdx = 0;
		int eIdx = srcArr.length-1;
		
		while(sIdx <= eIdx) {
			int mIdx = (sIdx+eIdx)/2;
			int compareValue = srcArr[mIdx];
			
			if(compareValue < targetValue) {
				sIdx = mIdx + 1;
			} else if(compareValue > targetValue) {
				eIdx = mIdx -1;
			} else {
				return true;
			}
		}
		
		return false;
	}
}

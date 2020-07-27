package baekjoon.binary.search;

import java.io.*;
import java.util.*;

public class NumberCard2 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int cardNum = Integer.valueOf(br.readLine());
    	String[] cardArr = br.readLine().split(" ");
    	Map<String, Integer> cardCntMap = new HashMap<String, Integer>();
    	for(int i=0; i<cardNum; i++) {
    		String currentCard = cardArr[i];
    		if(cardCntMap.containsKey(currentCard)) {
    			int currentCardCnt = cardCntMap.get(currentCard);
    			cardCntMap.put(currentCard, currentCardCnt+1);
    		} else {
    			cardCntMap.put(currentCard, 1);
    		}
    	}
    	
    	int findNum = Integer.valueOf(br.readLine());
    	String[] findArr = br.readLine().split(" ");
    	for(int i=0; i<findNum; i++) {
    		String targetNum = findArr[i];
    		if(cardCntMap.containsKey(targetNum)) {
    			System.out.print(cardCntMap.get(targetNum) + " ");
    		} else {
    			System.out.print(0 + " ");
    		}
    	}
    	
    	br.close();
    }
}
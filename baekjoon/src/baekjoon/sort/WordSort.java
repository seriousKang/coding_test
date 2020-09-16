package baekjoon.sort;

import java.util.*;

public class WordSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int wordCnt = Integer.parseInt(sc.nextLine());
		String[] words = new String[wordCnt];
		
		for(int i=0; i<wordCnt; i++) {
			words[i] = sc.nextLine();
		}
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() > s2.length()) {
					return 1;
				} else if(s1.length() < s2.length()) {
					return -1;
				}
				
				if(s1.compareTo(s2) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
//		System.out.println("words:" + Arrays.toString(words));
		
		Set<String> wordSet = new LinkedHashSet<String>();
		for(String word: words) {
			wordSet.add(word);
		}
		
		for(String word: wordSet) {
			System.out.println(word);
		}
	}
}

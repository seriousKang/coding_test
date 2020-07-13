package programmers.lv1.string;

import java.util.Arrays;
import java.util.Comparator;

public class StringSortDescendingOrder {
	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}

	public static String solution(String s) {
		String answer = "";

		Character[] cArr = new Character[s.length()];
		for (int i = 0; i < s.length(); i++) {
			cArr[i] = s.charAt(i);
		}

		Arrays.sort(cArr, Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cArr.length; i++) {
			sb.append(cArr[i]);
		}
		answer = sb.toString();

		return answer;
	}
}

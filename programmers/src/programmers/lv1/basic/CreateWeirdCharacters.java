package programmers.lv1.basic;

public class CreateWeirdCharacters {
	public String solution(String s) {
		char[] cArr = s.toCharArray();

		int cnt = 0;
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] == ' ') {
				cnt = 0;
				continue;
			}

			if (cnt % 2 == 0) {
				cArr[i] = Character.toUpperCase(cArr[i]);
			} else {
				cArr[i] = Character.toLowerCase(cArr[i]);
			}
			cnt++;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : cArr) {
			sb.append(c);
		}

		return sb.toString();
	}
}

package baekjoon.sort;

import java.util.*;

public class SortByAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int memberSize = Integer.parseInt(sc.nextLine());
		
		String[] members = new String[memberSize];
		for(int i=0; i<memberSize; i++) {
			members[i] = sc.nextLine();
		}
//		System.out.println("members:" + Arrays.toString(members));
		
		Arrays.sort(members, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int age1 = Integer.parseInt(s1.split(" ")[0]);
				int age2 = Integer.parseInt(s2.split(" ")[0]);
				
				if(age1 > age2) {
					return 1;
				} else if(age1 < age2) {
					return -1;
				} else {
					return 0;
				}
			}
		});
//		System.out.println("members:" + Arrays.toString(members));
		
		for(int i=0; i<memberSize; i++) {
			System.out.println(members[i]);
		}
	}
}

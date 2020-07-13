package programmers.lv1.basic;

public class Year2016 {
	public String solution(int a, int b) {
        final String[] DAYS = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        final int[] MONTHS = {
          0,
          31, 29, 31, 30,
          31, 30, 31, 31,
          30, 31, 30, 31
        };
        
        int dayCnt = 0;
        for(int i=0; i<a; i++) {
            dayCnt += MONTHS[i];
        }
        dayCnt += b;
        
        int targetDay = dayCnt % 7;
        return DAYS[targetDay];
    }
}

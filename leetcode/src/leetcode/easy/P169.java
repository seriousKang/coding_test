package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * title: Majority Element
 * difficulty: easy
 */
public class P169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int maxCnt = 0;
        int result = 0;

        for(int num: nums) {
            int cnt = cntMap.containsKey(num) ? cntMap.get(num)+1 : 1;
            if(cnt > maxCnt) {
                maxCnt = cnt;
                result = num;
            }
            cntMap.put(num, cnt);
        }

        return result;
    }
}

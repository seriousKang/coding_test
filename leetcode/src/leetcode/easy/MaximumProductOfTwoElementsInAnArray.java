package leetcode.easy;

import java.util.Arrays;

public class MaximumProductOfTwoElementsInAnArray {
	public int maxProduct(int[] nums) {
        int result;
        int arraySize = nums.length;
        
        Arrays.sort(nums);
        result = (nums[arraySize-1]-1)*(nums[arraySize-2]-1);
        
        return result;
    }
}

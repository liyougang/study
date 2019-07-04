package com.gang.leetcode.solution;

/**
 * @author ligang
 * @desc
 * @date 2019/6/28下午3:48
 **/
public class SerachInsertSolution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        for(int i=0; i<nums.length; i++){
            if(target <= nums[i]){
                return i;
            }
        }

        return nums.length;
    }
}

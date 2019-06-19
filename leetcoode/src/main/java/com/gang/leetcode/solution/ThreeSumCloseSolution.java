package com.gang.leetcode.solution;

import java.util.Arrays;

/**
 * @author ligang
 * @desc
 * @date 2019/6/19下午9:26
 **/
public class ThreeSumCloseSolution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        for(int i= 0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if((Math.abs(close) > Math.abs(target-(nums[i] + nums[left] + nums[right])))){
                    close = target-(nums[i] + nums[left] + nums[right]);
                }
                if(nums[i] + nums[left] + nums[right] > target){
                    right --;
                }else if(nums[i] + nums[left] + nums[right] < target){
                    left++;
                }else {
                    return target;
                }
            }
        }
        return target - close;
    }
}

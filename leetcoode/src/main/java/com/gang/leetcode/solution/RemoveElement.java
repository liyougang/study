package com.gang.leetcode.solution;

/**
 * @author ligang
 * @desc https://leetcode-cn.com/problems/remove-element/
 * @date 2019/6/20上午9:36
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index =0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}

package com.gang.leetcode.solution;


/**
 * @author ligang
 * @desc https://leetcode.com/problems/next-permutation/
 * @date 2019/6/21上午6:09
 **/
public class NextPermutationSolution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        int j = nums.length-1;

        while(i >=0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i>=0){
            while(nums[i] >= nums[j] && j>0){
                j--;
            }
            swap(i,j, nums);
        }

        reverse(i+1, nums.length-1, nums);
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int i, int j, int[] nums){
        int start = i;
        int end = j;
        while(start < end){
            swap(start, end, nums);
            start ++;
            end--;
        }
    }
}

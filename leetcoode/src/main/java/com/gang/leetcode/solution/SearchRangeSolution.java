package com.gang.leetcode.solution;

/**
 * @author ligang
 * @desc
 * @date 2019/6/28下午4:03
 **/
public class SearchRangeSolution{
    public int[] searchRange(int[] nums, int target){
        int leftIndex = searchLeft(nums, target);
        int rightIndex = searchRight(nums, target) -1;

        int[] rst = {-1,-1};
        if(leftIndex == nums.length || nums[leftIndex] != target){
            return rst;
        }

        rst[0] = leftIndex;
        rst[1] = rightIndex;

        return rst;
    }

    public int searchLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = (left + right) /2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public int searchRight(int[] nums, int target){
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = (left + right) /2;
            if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }
}

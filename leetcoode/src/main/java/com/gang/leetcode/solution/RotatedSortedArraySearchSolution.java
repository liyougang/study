package com.gang.leetcode.solution;

/**
 * @author ligang
 * @desc https://leetcode.com/problems/search-in-rotated-sorted-array/
 * [4,5,6,7,0,1,2]
 * 0
 * @date 2019/6/21上午8:56
 **/


public class RotatedSortedArraySearchSolution {
    public int search(int[] nums, int target) {
        if(nums.length <=0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        int part = twoPartSearch(left, right, nums);

        if(target <= nums[part] && target >= nums[left]){
            return twoPartSearch(left, part, target, nums);
        }else if(nums[part] == target){
            return part;
        }else{
            return twoPartSearch(part+1,right,target,nums);
        }

    }

    private int twoPartSearch(int left, int right, int[] nums){
        if(left == right){
            return left;
        }

        if(left < 0){
            return right;
        }

        int mid = (left + right) /2;
        if(nums[mid+1] > nums[mid]){
            if(nums[mid] < nums[left]){
                return twoPartSearch(left, mid-1, nums);
            }else{
                return twoPartSearch(mid+1, right, nums);
            }
        }else{
            return mid;
        }

    }

    private int twoPartSearch(int left, int right, int target, int[] nums){
        if(left == right){
            if(target == nums[left]){
                return left;
            }else {

                return -1;
            }
        }

        if(left > right){
            return -1;
        }
        int mid = (left+right)/2;
        if(nums[mid] > target){
            return twoPartSearch(left, mid, target, nums);
        }else if(nums[mid] < target){
            return twoPartSearch(mid+1, right, target, nums);
        }else{
            return mid;
        }

    }


}

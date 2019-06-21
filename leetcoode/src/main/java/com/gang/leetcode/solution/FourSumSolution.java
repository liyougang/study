package com.gang.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ligang
 * @desc https://leetcode.com/problems/4sum/
 * @date 2019/6/20上午6:09
 **/
public class FourSumSolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length-3;i++){
            List<List<Integer>> tempList = threeSum(nums, target, i);
            if(tempList.size() > 0){
                rst.addAll(tempList);
                while(i< nums.length-3 && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }

        return rst;
    }

    private List<List<Integer>> threeSum(int[] nums, int target, int i) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        for(int j = i+1; j<nums.length-2; j++){
            List<List<Integer>> temp = twoSum(nums, target, i, j);
            if(temp.size() > 0){
                rst.addAll(temp);
                while(j< nums.length-1 && nums[j] == nums[j+1]){
                    j++;
                }
            }
        }

        return rst;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int i, int j) {
        int left = j+1;
        int right = nums.length-1;
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        while(left < right){
            int temp = nums[i] + nums[j] + nums[left] + nums[right];
            if(temp > target){
                right--;
            }else if(temp < target){
                left++;
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[left]);
                list.add(nums[right]);

                rst.add(list);
                while(left < right && nums[left+1] == nums[left]){
                    left++;
                }

                while(left < right && nums[right-1] == nums[right]){
                    right--;
                }

                left++;
                right--;

            }
        }

        return rst;
    }

}

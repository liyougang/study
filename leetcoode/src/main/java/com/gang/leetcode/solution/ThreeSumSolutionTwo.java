package com.gang.leetcode.solution;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @desc：Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * @example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @author:gang.li
 * @date:2018-09-30 13:11
 */
public class ThreeSumSolutionTwo {

    public  static void  main(String[] args){
       // int[] nums = {-1, 0, 1, 2, -1, -4};

        int[] nums = {-1,0,1,2,-1,-4};


        // give
        System.out.println("give size:" + nums.length);
        System.out.println("give nums:" + JSON.toJSONString(nums));

        // cal cost time
        long start = System.currentTimeMillis();

        // solve
        List<List<Integer>> rst  =  new ThreeSumSolutionTwo().solution(nums);

        // cal cost time
        long cost = System.currentTimeMillis() - start;
        System.out.println("cost:" + cost +"ms");

        // print rst
        System.out.println("solution rst size:"+rst.size());
        System.out.println("solution rst:" +  JSON.toJSONString(rst));
    }

    public List<List<Integer>> solution(int[] nums){

        // 1.sort
        Arrays.sort(nums);

        List<List<Integer>> rsList = new ArrayList<List<Integer>>();

        // find other two num
        for(int i = 0;i<nums.length; i++){
            findOtherTwoNum(i, 0, nums.length-1, nums, rsList);
        }

        return rsList;
    }

    private void findOtherTwoNum(int i, int low, int high, int[] nums, List<List<Integer>> rsList){

        int target = nums[i];
        while(low < i && high > i){

            if(nums[low] + nums[high] + target == 0){
                List<Integer> rst = new ArrayList<Integer>();
                rst.add(nums[low]);
                rst.add(nums[i]);
                rst.add(nums[high]);

                if(!contains(rsList, rst)){
                    rsList.add(rst);
                }

                high --;
            }else if(nums[low] + nums[high] + target > 0){
                high --;
            }else if(nums[low] + nums[high] + target < 0){
                low ++;
            }
        }
    }

    private boolean contains( List<List<Integer>> rsList, List<Integer> rst){
        for(List<Integer> list : rsList){
            if(list.get(0).compareTo(rst.get(0)) == 0  && list.get(1).compareTo(rst.get(1)) == 0
                && list.get(2).compareTo(rst.get(2)) == 0 ){
                return true;
            }
        }

        return false;
    }

}

package com.gang.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ligang
 * @descb https://leetcode-cn.com/problems/subsets.txt/
 * @date 2019/7/5上午6:29
 **/
public class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        return enumerate(nums);
    }

    public List<List<Integer>> enumerate(int[] nums){
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        rst.add(new ArrayList<Integer>());

        for(Integer num : nums){
            int size = rst.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<Integer>();
                subset.addAll(rst.get(i));
                subset.add(num);

                rst.add(subset);
            }
        }

        return rst;
    }
}

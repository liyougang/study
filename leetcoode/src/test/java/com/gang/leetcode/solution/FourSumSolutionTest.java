package com.gang.leetcode.solution;

import com.alibaba.fastjson.JSON;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @author ligang
 * @desc
 * @date 2019/6/20上午6:35
 **/
public class FourSumSolutionTest {
    @Test
    public void test(){
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        FourSumSolution solution = new FourSumSolution();
        List<List<Integer>> rst = solution.fourSum(nums, target);

        List<List<Integer>> targetList = new ArrayList<List<Integer>>();
        targetList.add(Arrays.asList(new Integer[]{-2,-1,1,2}));
        targetList.add(Arrays.asList(new Integer[]{-2,0,0,2}));
        targetList.add(Arrays.asList(new Integer[]{-1,0,0,1}));

        System.out.println(JSON.toJSONString(rst));
        Assert.assertEquals(isEquals(rst,targetList), true);

    }

    @Test
    public void testZero(){
        int[] nums = {0, 0,0,0};
        int target = 0;

        FourSumSolution solution = new FourSumSolution();
        List<List<Integer>> rst = solution.fourSum(nums, target);

        List<List<Integer>> targetList = new ArrayList<List<Integer>>();
        targetList.add(Arrays.asList(new Integer[]{0,0,0,0}));

        System.out.println(JSON.toJSONString(rst));
        Assert.assertEquals(isEquals(rst,targetList), true);

    }

    private boolean isEquals(List<List<Integer>> sourceList, List<List<Integer>> targetList){
        if(sourceList.size() != targetList.size()){
            return false;
        }

        for(int i =0; i< sourceList.size(); i++){
            if(!isEqualsList(sourceList.get(i), targetList.get(i))){
                return false;
            }
        }

        return true;
    }
    private boolean isEqualsList(List<Integer> sourceList, List<Integer> targeList){
        Collections.sort(targeList);
        for(int i =0; i<sourceList.size(); i++){
            if(sourceList.get(i) != targeList.get(i)){
                return false;
            }
        }

        return true;
    }
}

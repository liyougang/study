package com.gang.leetcode.solution;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author ligang
 * @desc
 * @date 2019/6/28下午3:50
 **/
public class SerachInsertSolutionTest {

    @Test
    public void test(){
        int[] nums = {1,3};
        int target = 2;
        SerachInsertSolution solution = new SerachInsertSolution();
        int insertIndex = solution.searchInsert(nums, target);

        Assert.assertEquals(insertIndex, 1);
    }
}

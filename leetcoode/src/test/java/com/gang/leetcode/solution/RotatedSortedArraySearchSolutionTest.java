package com.gang.leetcode.solution;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author ligang
 * @desc
 * @date 2019/6/22上午7:47
 **/
public class RotatedSortedArraySearchSolutionTest {
    @Test
    public void test(){
        RotatedSortedArraySearchSolution searchSolution = new RotatedSortedArraySearchSolution();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int rst = searchSolution.search(nums, target);
        Assert.assertEquals(4, rst);
    }

    @Test
    public void testOne(){
        RotatedSortedArraySearchSolution searchSolution = new RotatedSortedArraySearchSolution();
        int[] nums = {1, 3};
        int target = 1;
        int rst = searchSolution.search(nums, target);
        Assert.assertEquals(0, rst);
    }

    @Test
    public void testTwo(){
        RotatedSortedArraySearchSolution searchSolution = new RotatedSortedArraySearchSolution();
        int[] nums = {1};
        int target = 0;
        int rst = searchSolution.search(nums, target);
        Assert.assertEquals(-1, rst);
    }

    @Test
    public void testThree(){
        RotatedSortedArraySearchSolution searchSolution = new RotatedSortedArraySearchSolution();
        int[] nums = {3,1};
        int target = 3;
        int rst = searchSolution.search(nums, target);
        Assert.assertEquals(0, rst);
    }

    @Test
    public void testFour() {
        RotatedSortedArraySearchSolution searchSolution = new RotatedSortedArraySearchSolution();
        int[] nums = {1, 3};
        int target = 1;
        int rst = searchSolution.search(nums, target);

        Assert.assertEquals(0, rst);
    }

    @Test
    public void testFive() {
        RotatedSortedArraySearchSolution searchSolution = new RotatedSortedArraySearchSolution();
        int[] nums = {1, 3};
        int target = 3;
        int rst = searchSolution.search(nums, target);

        Assert.assertEquals(1, rst);
    }

    @Test
    public void testSix() {
        RotatedSortedArraySearchSolution searchSolution = new RotatedSortedArraySearchSolution();
        int[] nums = {3, 1};
        int target = 1;
        int rst = searchSolution.search(nums, target);

        Assert.assertEquals(1, rst);
    }

    @Test
    public void testServen() {
        RotatedSortedArraySearchSolution searchSolution = new RotatedSortedArraySearchSolution();
        int[] nums = {5, 1, 3};
        int target = 1;
        int rst = searchSolution.search(nums, target);

        Assert.assertEquals(1, rst);
    }
}

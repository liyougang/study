package com.gang.leetcode.solution;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ligang
 * @desc
 * @date 2018/11/8上午6:40
 **/
public class MyAtoiSolutionTest {

    public static final int ZERO = 0;

    MyAtoiSolution solution = null;
    @BeforeClass
    public void init(){
        solution = new MyAtoiSolution();
    }

    @Test
    public void testOverMin(){
        int rst = solution.myAtoi("-21474836479");
        Assert.assertEquals(ZERO, rst);
    }

    @Test
    public void testOverMax(){
        int rst = solution.myAtoi("21474836479");
        Assert.assertEquals(ZERO, rst);
    }

    @Test
    public void testEndWithNotDigit(){
        int rst = solution.myAtoi("111a");
        Assert.assertEquals(111, rst);
    }

    @Test
    public void testStartWithNotDigit(){
        int rst = solution.myAtoi("a111");
        Assert.assertEquals(ZERO, rst);
    }

    @Test
    public void testDigit(){
        List<String> notMatch = new ArrayList<String>();
        for(int i =0; i< 100000; i++){
            int rst = solution.myAtoi(String.valueOf(i));
            if(rst != i){
                StringBuilder notMatcSb = new StringBuilder(String.valueOf(i))
                        .append("not eq")
                        .append(String.valueOf(rst));
                notMatch.add(notMatcSb.toString());
            }
        }
        Assert.assertEquals(ZERO, notMatch.size());
    }

}

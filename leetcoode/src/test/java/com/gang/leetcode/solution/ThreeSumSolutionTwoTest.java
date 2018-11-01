package com.gang.leetcode.solution;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;

import java.util.List;


public class ThreeSumSolutionTwoTest {

    private  static ThreeSumSolutionTwo threeSumSolution = new ThreeSumSolutionTwo();

    private static final int[] tinyNUms = {-1,0,1,2,-1,-4};

    private static final int[] ZeroNums = {0,0,0};

   @Test
    public void testTiny(){

        // process
        List<List<Integer>> rst = threeSumSolution.solution(tinyNUms);

        // print rst
        printRst(rst);

    }
    
    @Test
    public void testZero(){

        // process
        List<List<Integer>> rst = threeSumSolution.solution(ZeroNums);

        // print rst
        printRst(rst);

    }
    
    /**
     * 
     * @Description 
     * 
     * @param rst
     * @return void
     * @Author gang.li01
     * @Date 2018/10/25 14:13
     **/
    private void printRst(List<List<Integer>> rst){

        System.out.println("solution rst size:"+rst.size());
        System.out.println("solution rst:" +  JSON.toJSONString(rst));
    }

}

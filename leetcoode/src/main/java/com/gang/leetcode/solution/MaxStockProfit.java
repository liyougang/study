package com.gang.leetcode.solution;

/**
 * @author ligang
 * @desc
 * @date 2019/6/19下午5:23
 **/
public class MaxStockProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i =0; i<prices.length -1; i++){
           if(prices[i] < min){
               min = prices[i];
           }else{
               if(prices[i] - min > max){
                   max = prices[i] - min;
               }
           }

        }

        return max;
    }
}

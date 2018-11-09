package com.gang.leetcode.solution;

/***
 * @ref:https://leetcode.com/problems/reverse-integer/description/
 * Assume we are dealing with an environment which could only
 * store integers within the 32-bit signed integer
 * range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function
 * returns 0 when the reversed integer overflows.
 * @author: ligang
 * @desc:
 * @date: 2018/7/25下午6:31
 **/
public class ReverseNumSolution {

    public int reverse(int x){
        int rst = 0;
        int maxSub1 = 147483647;
        int maxSub2 = -147483648;
        int baseArr[] = {1,10,100,1000,10000,
                         100000, 1000000, 10000000,
                         100000000,1000000000};
        int maxDivs = 0;
        int temp =x;
        int firstIndex = baseArr.length - 1;
        boolean flag = true;
        boolean negativeFlag;
        negativeFlag = x < 0;

        for(int i = baseArr.length-1; i>=0; i--){
            if(i == baseArr.length -1){
                maxDivs = temp / baseArr[i];
            }
            int divs = temp / baseArr[i];
            if(i ==0 && ((!negativeFlag && maxDivs>=1) || (negativeFlag && maxDivs<= -1))){
                if((!negativeFlag && divs >2) || (negativeFlag && divs <-2)){
                    return 0;
                }else if(divs == 2 || divs == -2){
                     if(negativeFlag && rst < maxSub2){
                         return 0;
                     }else if(!negativeFlag && rst > maxSub1){
                         return 0;
                     }
                }
            }
            if(divs == 0 && flag){
                firstIndex --;
                continue;
            }
            flag = false;

            rst +=(divs*baseArr[firstIndex-i]);
            temp = (temp - divs*baseArr[i]);
        }
        return rst;
    }
}

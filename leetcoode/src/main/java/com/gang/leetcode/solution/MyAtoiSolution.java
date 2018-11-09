package com.gang.leetcode.solution;

/**
 * @author ligang
 * @desc
 * @date 2018/11/7上午8:33
 **/
public class MyAtoiSolution {

    public int myAtoi(String str){
        boolean negativeFlag = isNegative(str);
        if(negativeFlag){
            str = str.substring(1);
        }

        int rst = 0;
        int mod = 1;
        int max = 147483647;
        int last = 2;
        boolean start = false;

        for(int i = str.length()-1 ;i >=0;i--){
            char starChar = str.charAt(i);
            if(!start && !Character.isDigit(starChar)){
                 continue;
            }
            start = true;
            if(!Character.isDigit(starChar)){
                return 0;
            }
            int indexInt = Integer.valueOf(String.valueOf(starChar));
            if((negativeFlag && (rst > max+1)) || (!negativeFlag && (rst > max))){
                if(indexInt >= last){
                    return 0;
                }
            }

            rst = rst + Integer.valueOf(indexInt)*mod;
            mod = mod*10;
        }

        if(negativeFlag){
            return -1*rst;
        }

        return rst;
    }

    private boolean isNegative(String str){
        if(str.startsWith("-")){
            return true;
        }

        return false;
    }
}

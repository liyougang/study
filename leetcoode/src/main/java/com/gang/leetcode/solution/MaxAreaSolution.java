package com.gang.leetcode.solution;

/**
 * @author ligang
 * @desc
 * @date 2019/6/19下午8:49
 **/
public class MaxAreaSolution {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i<height.length-1; i++){
            for(int j = i+1; j<height.length; j++){
                max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
            }
        }

        return max;
    }

    public int maxAreadWithTwoPart(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right){
            max = Math.max(max, (right -left)*Math.min(height[left], height[right]));
            if(height[right] < height[left]){
                right--;
            }else {
                left++;
            }
        }

        return max;
    }
}

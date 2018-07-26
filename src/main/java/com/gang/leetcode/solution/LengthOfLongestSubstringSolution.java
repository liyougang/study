package com.gang.leetcode.solution;

/**
 * @author ligang
 * @desc Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @date 2018/7/22上午6:33
 **/
public class LengthOfLongestSubstringSolution {

    public static void main(String[] args){
        String str = "aa1";
        System.out.println("str:"+str);

        int maxSize = new LengthOfLongestSubstringSolution().lengthOfLongestSubstring2(str);
        System.out.println("maxSize:"+maxSize);
    }
    public int lengthOfLongestSubstring(String s){

        if(s == null || "".equals(s)){
            return 0;
        }
        int firstIndex =0;
        int currIndex =  firstIndex;
        int maxSize = 1;
        while(++currIndex <= (s.length()-1)){
            for(int i = currIndex-1; i>= firstIndex; i--){
                if(s.charAt(i) == s.charAt(currIndex)){
                    if((currIndex -firstIndex) > maxSize){
                        maxSize = currIndex -firstIndex;
                    }
                    firstIndex = i+1;
                    currIndex = firstIndex;
                    break;
                }
            }
        }
        if((currIndex -firstIndex) > maxSize){
            maxSize = currIndex -firstIndex;
        }
        return maxSize;

    }

    public int lengthOfLongestSubstring2(String s){

        if(s == null || "".equals(s)){
            return 0;
        }
        int h =0;
        int maxSize = 0;
        boolean arr[] = new boolean[256];
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            while(arr[c]){
                arr[s.charAt(h)] = false;
                h++;
            }
            arr[c] = true;
            maxSize = Math.max(maxSize, i-h+1);
        }

        return maxSize;

    }
}

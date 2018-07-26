package com.gang.leetcode.solution;

/**
 * @author ligang
 * @ref https://leetcode.com/problems/longest-palindromic-substring/description/
 * @desc
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 * @date 2018/7/25上午8:11
 **/
public class LongestPalindromeSolution {

    public String longestPalindrome(String s){
        if(s == null){
            return null;
        }
        return longestPalindromeSpand(s);
    }
    
     /**
      *
      * desc:简单的回文判断，遍历所有可能的子串
      * @param: 
      * @return:
      * @auther: ligang
      * @date: 2018/7/25 上午8:18
      */
    public String longestPalindromeSimple(String s){
        String maxSubStr = null;
        for(int i=0; i<s.length(); i++){
            for(int j =i; j<s.length(); j++){
                String subStr = s.substring(i, j+1);
                if(maxSubStr == null || checkPalindrome(subStr) && subStr.length() >= maxSubStr.length()){
                    maxSubStr = subStr;
                }
            }
        }
        return maxSubStr;
    }

    public String longestPalindromeSpand(String s){
        int low =0;
        int high=0;
        int maxLen = 0;
        for(int i=0; i<s.length()-1; i++){

             int maxOddLen = spand(i, i, s, maxLen);
             int maxEvnLen = spand(i, i+1, s, maxOddLen);
             if(maxEvnLen > maxLen){
                 maxLen = maxEvnLen;
                 if(maxLen % 2 == 0){
                     low =  i - ((maxLen)/2 -1);
                     high = i+ (maxLen)/2;
                 }else{
                     low =  i - (maxLen)/2;
                     high = i+ (maxLen)/2;
                 }

             }

        }
        return s.substring(low, high+1);
    }
    
     /**
      * 从中间向两边查找最大回文子串
      * desc:
      * @param: 
      * @return:
      * @auther: ligang
      * @date: 2018/7/25 下午1:04
      */
    public int spand(int i, int j, String s, int maxLen){
        while(i>= 0 && j<=s.length()-1 && s.charAt(i)  == s.charAt(j)){
            if(j-i+1 > maxLen){
                maxLen = j-i +1;
            }
            i--;
            j++;
        }

        return maxLen;
    }


    public boolean checkPalindrome(String s){
        int i = s.length()/2 -1;
        int j= i;
        if(s.length() % 2 == 0){
            i = s.length()/2 -1;
            j = i+1;
        }
        while(i>=0 && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return i == 0;
    }


    public static void main(String[] args){
        LongestPalindromeSolution solution = new LongestPalindromeSolution();
        String str1 = "bbbb";
        System.out.println("str1:"+ str1);
        String maxSubStr1 = solution.longestPalindrome(str1);
        System.out.println("maxSubStr1:"+maxSubStr1);

    }
}

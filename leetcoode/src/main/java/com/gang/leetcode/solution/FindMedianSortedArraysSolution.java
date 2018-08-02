package com.gang.leetcode.solution;

/**
 * @desc:
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @example:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * @author ligang
 * @date 2018/7/22下午4:22
 **/
public class FindMedianSortedArraysSolution {

   public double findMedianSortedArrays(int[] nums1, int[] nums2) throws Exception {
       if(nums1.length > nums2.length){
           return findMedianSortedArrays(nums2, nums1);
       }

       int x = nums1.length;
       int y = nums2.length;
       int low = 0;
       int high = x;
       while(low <= high){

           int partitionX = (low + high)/2;
           int partitionY = (nums1.length + nums2.length +1 )/2 - partitionX;

           int xLeft = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
           int xRight = (partitionX == nums1.length) ? Integer.MAX_VALUE : nums1[partitionX];

           int yLeft = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY-1];
           int yRight = (partitionY ==nums2.length) ? Integer.MAX_VALUE : nums2[partitionY];

           if(xLeft <= yRight && yLeft <= xRight){
               if((x+y) % 2 == 0){
                   return (Math.max(xLeft,yLeft) + Math.min(xRight,yRight))/2.0;
               }else{
                   return Math.max(xLeft, yLeft);
               }
           }else if(xLeft > yRight){
               high = partitionX-1;
           }else {
               low = partitionX+1;
           }
       }

       throw new Exception("not find");
   }

   public static void main(String[] args) throws Exception{
       int[] nums1 = {};
       int[] nums2 = {4};
       FindMedianSortedArraysSolution solution = new FindMedianSortedArraysSolution();
       double mid = solution.findMedianSortedArrays(nums1, nums2);
       System.out.println("mid:"+mid);

   }
}

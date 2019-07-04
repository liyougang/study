package com.gang.leetcode.solution;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

/**
 * @author ligang
 * @desc
 * @date 2019/7/3上午6:45
 **/
public class SearchRangeSolutionTest {
    @DataProvider(name = "readTxt")
    public Object[][] readTxt(){
        String fileName = "data/test.txt";
        Object[][] rst = new Object[0][2];
        try {
            rst = convertListToArray(read(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rst;
    }

    public List<String> read(String fileName) throws IOException {
        String fileNamePath = SearchRangeSolutionTest.class.getClassLoader().getResource(fileName).getPath();
        File file = new File(fileNamePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        List<String> rstList = new ArrayList();
        while((line = br.readLine()) != null){
             rstList.add(line);
        }

        return rstList;
    }

    public Object[][] convertListToArray(List<String> list){
        Object[][] rst = new Object[list.size()/2][1];
        for(int i=0; i<list.size(); i+=2){
            Map<String, Object> objMap = new HashMap<String, Object>();
            objMap.put("nums",  list.get(i).split(" "));
            String[] expertRst = list.get(i+1).split(" ");
            objMap.put("target", expertRst[0]);
            String[] copyArray = copyArray(expertRst, 1, expertRst.length);
            objMap.put("expert", copyArray);

            rst[i/2][0] = objMap;
        }
        return rst;
    }

    public String[] copyArray(String[] arr, int startIndex, int endIndex){
        endIndex = endIndex > arr.length ? arr.length : endIndex;
        startIndex = startIndex <0 ? 0 : startIndex;
        int size = endIndex - startIndex;
        String[] rst = new String[size];
        int index = 0;
        for(int i = startIndex; i<endIndex; i++){
            rst[index] = arr[i];
            index++;
        }

        return rst;
    }

    @Test(dataProvider = "readTxt")
    public void test1(Map<String, Object> obj){
        SearchRangeSolution solution = new SearchRangeSolution();
        int[] nums = convertStringToInt((String[])obj.get("nums"));
        int target = Integer.valueOf((String)obj.get("target"));
        int[] expert = convertStringToInt((String[])obj.get("expert"));
        int[] rst = solution.searchRange(nums, target);
        Assert.assertEquals(rst, expert);
    }

    public int[] convertStringToInt(String[] nums){
        int[] rst = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            rst[i] = Integer.valueOf(nums[i]);
        }

        return rst;
    }
}

package com.gang.leetcode.solution;

import com.alibaba.fastjson.JSON;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ligang
 * @desc
 * @date 2019/7/5上午6:38
 **/
public class SubSetsSolutionTest {
    @DataProvider(name = "readTxt")
    public Object[][] readTxt(){
        String fileName = "data/subsets.txt";
        Object[][] rst = new Object[0][1];
        try {
            rst = convertListToArray(read(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rst;
    }

    public List<String> read(String fileName) throws IOException {
        URL url = SubSetsSolutionTest.class.getClassLoader().getResource(fileName);
        String fileNamePath = SubSetsSolutionTest.class.getClassLoader().getResource(fileName).getPath();
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
        Object[][] rst = new Object[list.size()/2+1][1];
        for(int i=0; i<list.size(); i+=2){
            Map<String, Object> objMap = new HashMap<String, Object>();
            objMap.put("nums",  list.get(i).split(" "));
            rst[i/2][0] = objMap;
        }
        return rst;
    }

    @Test(dataProvider = "readTxt")
    public void test(Map<String, Object> obj){
        SubsetsSolution solution = new SubsetsSolution();
        int[] nums = convertStringToInt((String[])obj.get("nums"));
        List<List<Integer>> rst = solution.subsets(nums);
        System.out.println("rst:"+JSON.toJSONString(rst));
        Assert.assertEquals(rst.size(), 8);
    }

    public int[] convertStringToInt(String[] nums){
        int[] rst = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            rst[i] = Integer.valueOf(nums[i]);
        }

        return rst;
    }
}

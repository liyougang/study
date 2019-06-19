/**
 * Copyright (c) 2017, ShangHai HOWBUY INVESTMENT MANAGEMENT Co., Ltd.
 * All right reserved.
 * <p>
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF HOWBUY INVESTMENT
 * MANAGEMENT CO., LTD.  THE CONTENTS OF THIS FILE MAY NOT BE DISCLOSED
 * TO THIRD PARTIES, COPIED OR DUPLICATED IN ANY FORM, IN WHOLE OR IN PART,
 * WITHOUT THE PRIOR WRITTEN PERMISSION OF HOWBUY INVESTMENT MANAGEMENT
 * CO., LTD.
 */
package com.gang.demo.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @className Test
 * @description
 * @author gang.li01
 * @date 2019/1/30 19:51
 */
public class Test {

    public static void main(String[] args){
        Map<String, String> maps = new HashMap<String,String>();
        maps.put("1","test");

        Set<String> keySet = maps.keySet();
        keySet.add("12");
    }
}

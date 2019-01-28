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
package com.gang.demo.calculate.service;

import com.gang.demo.calculate.CalculateService;

/**
 * @className CalculateService
 * @description
 * @author gang.li01
 * @date 2019/1/28 16:29
 */
public class CalculateServiceImple implements CalculateService {

    @Override
    public int add(int numOne, int numTwo) {
        return numOne + numTwo;
    }
}

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
package com.gang.demo.calculate;

import com.gang.demo.calculate.service.CalculateServiceImple;
import com.gang.demo.rpc.server.RpcServer;

/**
 * @className RpcMan
 * @description
 * @author gang.li01
 * @date 2019/1/31 10:01
 */
public class RpcMan {
    public static void main(String[] args) throws Exception{
        RpcServer rpcServer = new RpcServer(8182);

        rpcServer.addService("com.gang.demo.calculate.CalculateService", new CalculateServiceImple());

        rpcServer.startServer();
    }
}

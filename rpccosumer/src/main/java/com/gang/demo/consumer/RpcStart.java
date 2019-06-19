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

import com.gang.demo.rpc.InterfaceCall;
import com.gang.demo.rpc.client.RpcClient;

/**
 * @className RpcStart
 * @description
 * @author gang.li01
 * @date 2019/1/29 17:52
 */
public class RpcStart {

    public static void main(String[] args) throws Exception{
        RpcClient rpcClient = new RpcClient();

        String serviceName = "com.gang.demo.calculate.CalculateService";
        String addres = "127.0.0.1:8182";

        InterfaceCall interfaceCall = new InterfaceCall();
        interfaceCall.setInterfaceName(serviceName);
        interfaceCall.setAddress(addres);
        rpcClient.consumerService(serviceName, interfaceCall);

        Object[] params = {1, 2};
        rpcClient.consumerService(serviceName, interfaceCall);

        String methodName = "add";

        rpcClient.sendMessage(serviceName, methodName, params);
    }
}

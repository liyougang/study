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
package com.gang.demo.rpc.client;

import com.gang.demo.rpc.InterfaceCall;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * @className RpcClient
 * @description
 * @author gang.li01
 * @date 2019/1/28 16:27
 */
public class RpcClient {

    private Map<String, List<InterfaceCall>> consumerServiceMap = new HashMap<String, List<InterfaceCall>>();

    public void consumerService(String interfaceName, InterfaceCall interfaceCall){
       List<InterfaceCall> interfaceCallsList = consumerServiceMap.get(interfaceName);
       if(interfaceCallsList == null){
           interfaceCallsList = new ArrayList<InterfaceCall>();
           consumerServiceMap.put(interfaceName, interfaceCallsList);
       }

       interfaceCallsList.add(interfaceCall);
    }

    public  void sendMessage(String serviceName, String methodName, Object[] params) {
        try {
            InterfaceCall interfaceCall = routeAddress(serviceName);
            interfaceCall.setParams(params);
            interfaceCall.setMethodName(methodName);

            String address = interfaceCall.getAddress();
            String[] ipAndPort = address.split(":");

            String ip = ipAndPort[0];

            int port = Integer.valueOf(ipAndPort[1]);

            System.out.println("连接到主机：" + ip + " ，端口号：" + port);
            Socket client = new Socket(ip, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());


            Socket socket = new Socket(ip, port);

            writeObj(interfaceCall, socket);

            Object rst = readObj(socket);

            System.out.print("rs :"+rst.toString());
            System.out.print("服务器响应");


           // client.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private InterfaceCall routeAddress(String serviceName){
        List<InterfaceCall> interfaceCalls = consumerServiceMap.get(serviceName);

        return interfaceCalls.get(0);
    }

    private  void writeObj(InterfaceCall interfaceCall ,Socket s) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(s.getOutputStream()));
        os.writeObject(interfaceCall);
        os.flush();
        os.close();
    }

    private Object readObj(Socket s) throws Exception{
       ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
       Object obj = ois.readObject();

       return obj;
    }
}

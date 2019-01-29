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

/**
 * @className RpcClient
 * @description
 * @author gang.li01
 * @date 2019/1/28 16:27
 */
public class RpcClient {

    public static void main(String[] args) throws Exception{
        String interfaceName = "com.gang.demo.calculate.CalculateService";
        String methodName = "add";
        Object[] params = new Object[]{1, 2};
        String serverIp = "127.0.0.1";
        int serverPort = 8181;

        sendMessage(serverIp, serverPort);

//        try {
//            InterfaceCall interfaceCall = new InterfaceCall();
//            interfaceCall.setInterfaceName(interfaceName);
//            interfaceCall.setMethodName(methodName);
//            interfaceCall.setParams(params);
//
//
//            Socket socket = new Socket(serverIp, serverPort);
//
//            //构建IO
//            InputStream is = socket.getInputStream();
//            OutputStream os = socket.getOutputStream();
//
//            ObjectOutputStream obs = new ObjectOutputStream(os);
//
//            obs.writeObject(interfaceCall);
//
//            obs.flush();
//
//            //读取服务器返回的消息
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String mess = br.readLine();
//            System.out.println("服务器：" + mess);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void sendMessage(String serverName, int port) {
        try {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

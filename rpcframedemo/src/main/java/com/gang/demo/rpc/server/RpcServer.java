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
package com.gang.demo.rpc.server;

import com.gang.demo.calculate.CalculateService;
import com.gang.demo.rpc.InterfaceCall;
import com.sun.corba.se.pept.encoding.OutputObject;
import com.sun.corba.se.pept.protocol.MessageMediator;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @className RpcServer
 * @description
 * @author gang.li01
 * @date 2019/1/28 16:44
 */
public class RpcServer {
    static  Map<String, Object> serversMap = new HashMap<String, Object>();

    public static void main(String[] args){

        int serverPort = 8181;

        InterfaceCall interfaceCall = new InterfaceCall();

        try {
            ServerSocket ss = new ServerSocket(serverPort);
            System.out.println("启动服务器....");
            Socket s = ss.accept();
            System.out.println("客户端:" + s.getInetAddress().getLocalHost() + "已连接到服务器");

            ObjectInputStream br = new ObjectInputStream(s.getInputStream());
            //读取客户端发送来的消息
            Object ob = br.readObject();

            InterfaceCall interfaceCall1 = (InterfaceCall) ob;
            HandProcess handProcess = new HandProcess();

            Class interfaceClazz = Class.forName(interfaceCall1.getInterfaceName());

            Object object = Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz}, handProcess);
            Method method =getMethod(interfaceClazz.getMethods(), interfaceCall.getMethodName(), interfaceCall.getParams());

            try {
                Object rs = handProcess.invoke(object, method, interfaceCall.getParams());
                System.out.println("客户端："+ rs.toString());
                ObjectOutputStream oo = new ObjectOutputStream(s.getOutputStream());
                oo.writeObject(rs);

                oo.flush();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static  Method getMethod(Method[] methods, String methodName, Object[] params){
        for(Method method : methods){
            if(method.getName().equals(methodName) && params.length == method.getParameterTypes().length){
                return method;
            }
        }

        throw new RuntimeException(methodName + " is not exist");
    }
}

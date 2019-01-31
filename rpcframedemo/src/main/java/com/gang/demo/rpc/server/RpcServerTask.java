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

import com.gang.demo.rpc.InterfaceCall;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @className RpcServerTask
 * @description
 * @author gang.li01
 * @date 2019/1/31 11:08
 */
public class RpcServerTask implements Runnable{
    public RpcServer rpcServer;

    public RpcServerTask(RpcServer rpcServer){
        this.rpcServer = rpcServer;
    }
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                ServerSocket serverSocket = rpcServer.getServerSocket();
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());

                Object clientObj = readObject(server);

                InterfaceCall interfaceCall = decode(clientObj);

                Object rs = processService(interfaceCall);

                writeObj(rs, server);

                System.out.print("process end");

//                DataInputStream in = new DataInputStream(server.getInputStream());
//                System.out.println(in.readUTF());
//                DataOutputStream out = new DataOutputStream(server.getOutputStream());
//                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");

              //  server.close();
            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e)
            {
                e.printStackTrace();
                break;
            }catch (Throwable e){
                e.printStackTrace();
                break;
            }
        }
    }

    public  void startServer(int port){
        try
        {
            Thread t = new RpcServer(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    private Object readObject(Socket s) throws Throwable{
        ObjectInputStream br = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
        //读取客户端发送来的消息
        Object obj = br.readObject();
        return obj;
    }

    private void writeObj(Object rst, Socket s) throws Exception {
        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(s.getOutputStream()));
        os.writeObject(rst);
        os.flush();
        os.close();
    }

    private InterfaceCall decode(Object obj){
        return (InterfaceCall) obj;
    }

    private  Object processService(InterfaceCall interfaceCall) throws Throwable{
        HandProcess handProcess = new HandProcess();
        Class interfaceClazz = Class.forName(interfaceCall.getInterfaceName());
        Object object = rpcServer.findServiceByName(interfaceCall.getInterfaceName());
        Method method =getMethod(interfaceClazz.getMethods(), interfaceCall.getMethodName(), interfaceCall.getParams());

        Object rs = handProcess.invoke(object, method, interfaceCall.getParams());

        return rs;
    }

    private   Method getMethod(Method[] methods, String methodName, Object[] params){
        for(Method method : methods){
            if(method.getName().equals(methodName) && params.length == method.getParameterTypes().length){
                return method;
            }
        }

        throw new RuntimeException(methodName + " is not exist");
    }



}

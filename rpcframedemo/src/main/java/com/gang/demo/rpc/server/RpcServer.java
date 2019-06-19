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

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

/**
 * @className RpcServer
 * @description
 * @author gang.li01
 * @date 2019/1/28 16:44
 */
public class RpcServer extends Thread{
    static  Map<String, Object> serversMap = new HashMap<String, Object>();

    private ServerSocket serverSocket;
    public RpcServer(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(1000000);
    }

    public  void startServer(){

       RpcServerTask rpcServerTask = new RpcServerTask(this);

       rpcServerTask.run();
    }

    private  Map<String, Object> serviceMap = new HashMap<String, Object>();

    public void addService(String interfaceName, Object obj){
        serversMap.put(interfaceName, obj);
    }

    public  Object findServiceByName(String interfaceName){
        return serversMap.get(interfaceName);
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
}

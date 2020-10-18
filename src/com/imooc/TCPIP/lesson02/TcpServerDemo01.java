package com.imooc.TCPIP.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @classname TcpServerDemo01
 * @description：类的描述
 * @author：dml
 * @date 2020/10/18 15:53
 * @version: 1.0
 */
public class TcpServerDemo01 {
    // 服务端
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is =null;
        ByteArrayOutputStream baos = null;
        try {
            // 1. 等有一个地址
            serverSocket = new ServerSocket(9999);
            // 2. 等待客户端连接
            socket = serverSocket.accept();
            //读取客户端的内容
            is = socket.getInputStream();
            // 管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len=is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is !=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

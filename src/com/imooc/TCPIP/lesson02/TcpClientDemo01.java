package com.imooc.TCPIP.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @classname TcpClientDemo01
 * @description：类的描述
 * @author：dml
 * @date 2020/10/18 15:53
 * @version: 1.0
 */
public class TcpClientDemo01 {
    // 客户端
    public static void main(String[] args) {
        Socket socket =null;
        OutputStream os = null;
        try {
            // 1. 知道服务器的地址和端口
            InetAddress serverIP = InetAddress.getByName("localhost");
            int port =9999;
            // 2.创建一个socket连接
            socket = new Socket(serverIP, port);
            // 3. 发送消息IO流
            os = socket.getOutputStream();
            os.write("测试是否连通".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os != null){
                try {
                    os.close();
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
        }
    }



}

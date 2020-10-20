package com.imooc.TCPIP.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @classname UdpClientDemo01
 * @description：UDP练习，不需要发送端和接收端进行连接，在UDP中没有服务器和客户端的概念
 * @author：dml
 * @date 2020/10/20 14:29
 * @version: 1.0
 */
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1. 建立一个scoket
        DatagramSocket socket = new DatagramSocket();
        //2. 建个包
        String msg = "测试，发送消息";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port =9090;

        // 打一个包  参数分别为  数据，数据的起始，结束，ip,端口
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
        //3.发送包
        socket.send(packet);

        //关闭端口
        socket.close();
    }
    
    
}

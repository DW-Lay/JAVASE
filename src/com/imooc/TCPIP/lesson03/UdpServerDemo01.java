package com.imooc.TCPIP.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @classname UdpServerDemo01
 * @description：充当udp连接中的接收端
 * @author：dml
 * @date 2020/10/20 14:48
 * @version: 1.0
 */
public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception {
        // 1.开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet); //阻塞式接收

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }

}

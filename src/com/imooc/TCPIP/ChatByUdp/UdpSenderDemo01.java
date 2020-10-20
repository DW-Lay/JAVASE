package com.imooc.TCPIP.ChatByUdp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @classname UdpSenderDemo01
 * @description：类的描述
 * @author：dml
 * @date 2020/10/20 15:13
 * @version: 1.0
 */
public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        //准备数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String data = reader.readLine();
            byte[] datas = data.getBytes();

            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));

            socket.send(packet);
            if(data.equals("bye")){
                break;
            }
        }
        socket.close();
    }

}

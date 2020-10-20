package com.imooc.TCPIP.ChatByUdp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @classname UdpReciverDemo01
 * @description：类的描述
 * @author：dml
 * @date 2020/10/20 15:20
 * @version: 1.0
 */
public class UdpReciverDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9999);

        while(true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);

            byte[] data = packet.getData();
            String receiveData = new String(data,0,data.length);

            System.out.println(receiveData);
            if(receiveData.trim().equals("bye")){
                break;
            }

        }
        socket.close();

    }


}

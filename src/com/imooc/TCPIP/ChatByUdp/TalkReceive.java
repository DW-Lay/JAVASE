package com.imooc.TCPIP.ChatByUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @classname TalkReceive
 * @description：类的描述
 * @author：dml
 * @date 2020/10/20 16:23
 * @version: 1.0
 */
public class TalkReceive implements Runnable{
    private DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port,String msgFrom) {
        this.msgFrom= msgFrom;
        this.port =port;
        try {
            this.socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while(true){

            try {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);

                byte[] data = packet.getData();
                String receiveData = new String(data,0,data.length);

                System.out.println(msgFrom+":"+receiveData);
                if(receiveData.trim().equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        socket.close();
    }
}

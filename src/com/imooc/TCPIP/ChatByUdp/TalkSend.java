package com.imooc.TCPIP.ChatByUdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @classname TalkSend
 * @description：类的描述
 * @author：dml
 * @date 2020/10/20 15:52
 * @version: 1.0
 */
public class TalkSend implements Runnable{

    private DatagramSocket socket =null;
    private BufferedReader reader =null;


    private int fromPort;
    private String  toIP;
    private int toPort;

    public TalkSend(int fromPort,String toIP,int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort =toPort;
        try{
            this.socket =new DatagramSocket(fromPort);
            this.reader = new BufferedReader(new InputStreamReader(System.in));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while(true){
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIP, this.toPort));
                socket.send(packet);
                if(data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}

package com.imooc.TCPIP.ChatByUdp;

/**
 * @classname TalkStudent
 * @description：类的描述
 * @author：dml
 * @date 2020/10/20 16:29
 * @version: 1.0
 */
public class TalkStudent {

    public static void main(String[] args) {

        //开启两个线程
        new Thread(new TalkSend(5555,"localhost",7777)).start();
        new Thread(new TalkReceive(6666,"老师")).start();
    }
}

package com.imooc.TCPIP.ChatByUdp;

/**
 * @classname TalkTeacher
 * @description：类的描述
 * @author：dml
 * @date 2020/10/20 16:31
 * @version: 1.0
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(8888,"localhost",6666)).start();
        new Thread(new TalkReceive(7777,"学生")).start();


    }


}

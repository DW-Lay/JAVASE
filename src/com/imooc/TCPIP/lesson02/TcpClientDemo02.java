package com.imooc.TCPIP.lesson02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @classname TcpClientDemo02
 * @description：类的描述
 * @author：dml
 * @date 2020/10/18 17:21
 * @version: 1.0
 */
public class TcpClientDemo02 {
    public static void main(String[] args)  throws  Exception{
        // 1. 创建socket链接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        // 2. 创建一个输出流
        OutputStream os = socket.getOutputStream();
        // 3.读取文件
        FileInputStream fis = new FileInputStream(new File("D:\\javaStudy\\JAVASE\\src\\发送.jpg"));
        // 4. 写出文件
        byte[] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        // 通知服务器，我已经结束了
        socket.shutdownOutput(); // 已经结束发送

        // 确定服务器接收完毕，才能断开连接
        InputStream inputStream = socket.getInputStream();
        // String byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=inputStream.read(buffer2))!= -1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());

        //关闭资源
        baos.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();
    }
}

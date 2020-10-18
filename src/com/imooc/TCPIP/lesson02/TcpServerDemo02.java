package com.imooc.TCPIP.lesson02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @classname TcpServerDemo02
 * @description：类的描述
 * @author：dml
 * @date 2020/10/18 15:53
 * @version: 1.0
 */
public class TcpServerDemo02 {
    // 服务端
    public static void main(String[] args) throws IOException {
      // 1. 创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        // 2. 监听客户端的连接
        Socket socket = serverSocket.accept();// 阻塞式监听
        // 3. 获取输入流
        InputStream is = socket.getInputStream();

        //4. 文件输出
        FileOutputStream fos = new FileOutputStream(new File("recive.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        //通知客户端，我接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("我已经接收完毕".getBytes());

        //关闭资源
        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }

}

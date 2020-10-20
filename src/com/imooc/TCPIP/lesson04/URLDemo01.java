package com.imooc.TCPIP.lesson04;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @classname URLDemo01
 * @description：类的描述
 * @author：dml
 * @date 2020/10/20 17:15
 * @version: 1.0
 */
public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8080/helloWorld/index.jsp?username=nihao&passwprd=123");
        System.out.println(url.getProtocol()); //协议
        System.out.println(url.getHost()); // 主机
        System.out.println(url.getPort()); //端口
        System.out.println(url.getPath()); // 文件
        System.out.println(url.getFile()); // 全路径
        System.out.println(url.getQuery()); //参数


    }


}

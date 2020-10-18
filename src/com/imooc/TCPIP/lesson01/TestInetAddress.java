package com.imooc.TCPIP.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @classname TestIP
 * @description：测试IP
 * @author：dml
 * @date 2020/10/18 14:55
 * @version: 1.0
 */
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            // 查询本机地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress);
            InetAddress inetAddress3 = InetAddress.getByName("localhost");
            System.out.println(inetAddress3);
            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);

            //得到百度的ip地址
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);
            // 常用方法
            System.out.println(inetAddress2.getAddress());
            System.out.println(inetAddress2.getCanonicalHostName());  // 获取规范的名字
            System.out.println(inetAddress2.getHostAddress());  // ip
            System.out.println(inetAddress2.getHostName());  // 域名或者电脑自己的名字

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}

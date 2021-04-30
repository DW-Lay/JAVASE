package com.imooc.TCPIP.lesson04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 * @classname URLDown
 * @description：类的描述
 * @author：dml
 * @date 2020/10/20 17:18
 * @version: 1.0
 */
public class URLDown {
    public static void main(String[] args) throws IOException {
        // 1.下载地址
        URL url = new URL("https://m801.music.126.net/20201020175517/05cc7deb1fc930bcc8da942cd7751c42/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/4442416836/1b48/e465/2c6b/e02d7684de7be5fd873a6549e900cd30.m4a");
        //2.连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("f.m4a");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();  //断开连接

    }
}

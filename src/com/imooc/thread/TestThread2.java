package com.imooc.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Lincoln
 * @classname TestThread2
 * @description 练习Thread,实现多线程同步下载图片
 * @params TODO
 * @return
 * @date 2020/7/12 21:24
 */
public class TestThread2 extends Thread{

    private String url; //网络的图片网址
    private String name; // 保存的文件名

    public  TestThread2(String url,String name){
        this.url = url;
        this.name = name;

    }

    //下载图片的线程执行体
    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为"+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://pic3.zhimg.com/v2-d735a67064440bb01aa66936187269f9_1440w.jpg?source=172ae18b","1.jpg");
        TestThread2 t2 = new TestThread2("https://pic3.zhimg.com/v2-d735a67064440bb01aa66936187269f9_1440w.jpg?source=172ae18b","2.jpg");
        TestThread2 t3 = new TestThread2("https://pic3.zhimg.com/v2-d735a67064440bb01aa66936187269f9_1440w.jpg?source=172ae18b","3.jpg");

        t1.start();
        t2.start();
        t3.start();

    }

}
// 下载器
class WebDownloader{
    public void downloader(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }

    }
}

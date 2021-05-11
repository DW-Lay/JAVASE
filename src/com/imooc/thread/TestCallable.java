package com.imooc.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author Lincoln
 * @classname TestCallable
 * @description 练习创建方式三：实现Callable接口
 * @params TODO
 * @return
 * @date 2020/7/12 23:08
 */

//使用Callable的好处
//1、可以定义返回值
//2、可以抛出异常
public class TestCallable implements Callable<Boolean> {

    private String url; //网络的图片网址
    private String name; // 保存的文件名

    public  TestCallable(String url,String name){
        this.url = url;
        this.name = name;

    }

    //下载图片的线程执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为"+name);

        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://pic3.zhimg.com/v2-d735a67064440bb01aa66936187269f9_1440w.jpg?source=172ae18b","1.jpg");
        TestCallable t2 = new  TestCallable("https://pic3.zhimg.com/v2-d735a67064440bb01aa66936187269f9_1440w.jpg?source=172ae18b","2.jpg");
        TestCallable t3 = new  TestCallable("https://pic3.zhimg.com/v2-d735a67064440bb01aa66936187269f9_1440w.jpg?source=172ae18b","3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean>r1 = ser.submit(t1);
        Future<Boolean>r2 = ser.submit(t2);
        Future<Boolean>r3 = ser.submit(t3);

        // 获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);


        //关闭服务
        ser.shutdown();

    }

}



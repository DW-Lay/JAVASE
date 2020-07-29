package com.imooc.reflection;

/**
 * @author Lincoln
 * @classname Test02
 * @description 类的描述
 * @params TODO
 * @return
 * @date 2020/7/10 10:43
 */
public class Test02 {
    public static void main(String[] args) {

        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父加载器--> 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取扩展类加载器的父类加载器-->根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        // 双亲委派机制
         // java.lang.String --> ...  不断的去找上级加载器是否有这个jar包


        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /**
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\charsets.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\deploy.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\access-bridge-64.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\cldrdata.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\dnsns.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\jaccess.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\jfxrt.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\localedata.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\nashorn.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\sunec.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\sunjce_provider.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\sunmscapi.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\sunpkcs11.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\ext\zipfs.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\javaws.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\jce.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\jfr.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\jfxswt.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\jsse.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\management-agent.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\plugin.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\resources.jar;
         * C:\Program Files\Java\jdk1.8.0_212\jre\lib\rt.jar;
         * E:\JAVACODE\HelloWorld\out\production\HelloWorld;
         * C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.1\lib\idea_rt.jar
         */
    }
}

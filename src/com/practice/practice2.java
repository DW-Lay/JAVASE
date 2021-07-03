package com.practice;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lincoln
 * @classname practice2
 * @description 类的描述
 * @params
 * @return
 * @date 2021/4/30 18:49
 */
public class practice2 {
    public static void main(String[] args) {

        String str1 = new String("test");
        String str2 = new String("test");
        String str3 = "test";
        String str4 = "test";
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode()==str2.hashCode());
        System.out.println(str1.hashCode()==str3.hashCode());
        System.out.println(str3==str4);
        System.out.println(str3==str1);
        HashSet<String> strings = new HashSet<>();
        strings.add(str1);
        strings.add(str2);
        System.out.println(strings.size());
        strings.add(str3);
        System.out.println(strings.size());
        ConcurrentHashMap con = new ConcurrentHashMap();
    }
}

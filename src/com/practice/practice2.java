package com.practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
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
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//        String str1 = new String("test");
//        String str2 = new String("test");
//        String str3 = "test";
//        String str4 = "test";
//        System.out.println(str1==str2);
//        System.out.println(str1.equals(str2));
//        System.out.println(str1.hashCode()==str2.hashCode());
//        System.out.println(str1.hashCode()==str3.hashCode());
//        System.out.println(str3==str4);
//        System.out.println(str3==str1);
//        HashSet<String> strings = new HashSet<>();
//        strings.add(str1);
//        strings.add(str2);
//        System.out.println(strings.size());
//        strings.add(str3);
//        System.out.println(strings.size());
//        ConcurrentHashMap con = new ConcurrentHashMap();

//        HashMap map = new HashMap<String,String>();
//        map.put("name","zhang");
//        map.put("name",null);
//        map.put("","lis");
//        System.out.println(map.size());
//        System.out.println(map.get("name"));
//
//        Hashtable<Object, Object> table = new Hashtable<>();
//          double i =2.1;
//          long a =9223372036854775807L;
//        List<Integer> list =  new ArrayList<Integer>();
//        Method method = list.getClass().getMethod("add", Object.class); //要抛出个异常
//        method.invoke(list,"测试");  // 也要抛出异常
//        System.out.println(list.toString());
        Integer int1 = 1;
        Integer int2= new Integer(1);
        Integer int3 =2-1;
        Integer int4 = 200;
        Integer int5 = 200;
        int int6=200;
        System.out.println(int1==int2);
        System.out.println(int1==int3);
        System.out.println(int4==int5);
        System.out.println(int4==int6);

    }
}

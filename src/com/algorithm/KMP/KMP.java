package com.algorithm.KMP;

import java.util.Arrays;

/**
 * @program: HelloWorld
 * @description: KMP算法关键写法
 * @author: 董明林
 * @date: 2021-06-26 09:57:27
 */
public class KMP {
    public static void main(String[] args) {
        String s = "aabaaf";
        int[] res = new KMP().getNext(s);
        System.out.println(Arrays.toString(res));

        String test1 = "aaaaaa";
        String test2 = "bba";
        System.out.println(new KMP().strStr(test1,test2));
    }

    private int[] getNext(String s){
        int[] next = new int[s.length()];
        // 初始化  j=0, 前缀表next[0]=0;
        next[0] = 0;
        int j=0;
        for (int i = 1; i < s.length(); i++) {
            // 当前后缀不同的情况
            // 在我们的代码实现中就是遇见冲突就看前一位
            while(j>0 && s.charAt(i)!=s.charAt(j)){
                j = next[j-1]; // 这个操作是坚持不变的循环不变量
            }
            // 当前后缀相同的情况
            if(s.charAt(i)==s.charAt(j))
                j++;
            // 更新next
            next[i]=j;
        }
        return next;
    }


    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(haystack.length()==0){
            return -1;
        }
        int[] next = getNext(needle);
        System.out.println(Arrays.toString(next));
        int j =0;
        for(int i=0;i<haystack.length();i++){
            while(j>0 && haystack.charAt(i)!=needle.charAt(j)){
                j = next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if(j==needle.length()){
                return (i-needle.length()+1);
            }
        }
        return -1;
    }


}
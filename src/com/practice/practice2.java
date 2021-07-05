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
    public static void main(String[] args) {
//        System.out.println(new practice2().compressString("aabcccccaaa"));
//        int[] p  =  {4,2,1};
//        System.out.println(new practice2().petalsBreak(p));
        int[][]rooms= {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[] start = {0,0};
        int[] end  ={2,2};
        System.out.println(new practice2().minimumInitHealth(rooms, start, end));

    }


    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        // write code here
        int res =0;
        int m= rooms.length;
        int n= rooms[0].length;
        int[][] flag = new int[m][n];
        res= dfs(startPoint[0],startPoint[1],endPoint[0],endPoint[1],flag,0,rooms);
        return 0-res;
    }
    public int dfs(int x,int y,int x1,int y1,int[][] flag,int sum,int[][] rooms){
        if(x>x1 ||x <0||y>y1 || y<0 || flag[x][y]==1){
            return Integer.MIN_VALUE;
        }
        if(x==x1 && y ==y1){
            return sum;
        }
        else {
            flag[x][y]=1;
            int res =  Math.max(dfs(x+1,y,x1,y1,flag,sum,rooms),dfs(x-1,y,x1,y1,flag,sum,rooms));
            res =  Math.max(res,dfs(x,y+1,x1,y1,flag,sum,rooms));
            res =  Math.max(res,dfs(x,y-1,x1,y1,flag,sum,rooms));
            flag[x][y]=0;
            return sum +=res;
        }
    }


    public int petalsBreak(int[] petals) {
        // write code here
        int count=0;
        for(int petal:petals ){
            count +=(petal>>1)+(petal&1);
        }
        return count;
    }

    public String compressString(String param) {
        // write code here
        StringBuilder stringBuilder = new StringBuilder();
        int strLength = param.length();
        int count = 1;//记录重复个数
        for (int i = 0; i < strLength-1; ++i) {
            if (param.charAt(i) == param.charAt(i+1)) {
                count++;
            } else {
                if (count == 1) {
                    stringBuilder.append(param.charAt(i));
                } else {
                    stringBuilder.append(param.charAt(i));
                    stringBuilder.append(count);

                }
                count = 1;//这句重置不要忘记
            }
        }
        if (count == 1) {
            stringBuilder.append(param.charAt(strLength-1));
        } else {
            stringBuilder.append(param.charAt(strLength-1));
            stringBuilder.append(count);

        }
        return stringBuilder.toString();
    }
}

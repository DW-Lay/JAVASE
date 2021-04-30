package com.imooc.sort;

import java.util.Arrays;

/**
 * @classname chaRuSort
 * @description：插入排序
 * @author：dml
 * @date 2021/4/30 16:21
 * @version: 1.0
 */
public class chaRuSort {
    public static void main(String[] args) {
        int[] array = {2,5,1,3,8,3,5};
        int j;
        for(int i=1;i<array.length;++i){
            int temp = array[i];
            for( j=i-1;j>=0;--j){
                if(temp>array[j]){
                    break;
                }else{
                    array[j+1]=array[j];
                }
            }
            // 因为出循环之前又减了一个数，所以是array[j+1] = temp;
            array[j+1] =temp;
        }
        System.out.println(Arrays.toString(array));
    }
}

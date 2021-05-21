package com.algorithm.beibaowenti;

import java.util.Scanner;

/**
 * @program: HelloWorld
 * @description: 背包问题代码1 采用二维数组来做
 * @author: 董明林
 * @date: 2021-06-25 17:44:15
 */
public class BeiBaoWenTi {

    public static void main(String[] args) {
        /*
        采用控制台输入
         */
//        Scanner sc = new Scanner(System.in);
//        String strW = sc.nextLine();
//        int w = Integer.parseInt(strW);
//        String strWeight = sc.nextLine();
//        String strValue = sc.nextLine();
//        String[] weights = strWeight.split(",");
//        String[] values = strValue.split(",");
//
//        int[] weights2 =new int[weights.length];
//        int[] values2 = new int[values.length];
//
//        for (int i = 0; i < weights.length; i++) {
//            weights2[i] = Integer.parseInt(weights[i]);
//        }
//        for (int i = 0; i < values.length; i++) {
//            values2[i] = Integer.parseInt(values[i]);
//        }

        /*
        采用直接测试的
         */
        BeiBaoWenTi beibao = new BeiBaoWenTi();
        beibao.twoDimensionMethod();
        beibao.oneDimensionMethod();

    }


    //  ================二维数组的写法==================================

    private  void twoDimensionMethod(){
        int w = 4;  // 背包的最大承重量
        int[] weights2 = {1,3,4};  // 重量
        int[] values2 ={15,20,30}; // 价值

        int n = weights2.length;
        int[][] dp = new int[n][w+1];
        // dp[i][j]表示从0-i里任选物品，其重量为j时 价值为dp[i][j]
        // 初始化
        // dp[i][0] 全部为0，因为放置的物品为0个，其价值一定是为0
        // 初始化必须倒序遍历
        // 如果给定的价值有负数，则所有非0下标应该初始化为负无穷
        for(int j=w;j>=weights2[0];j--){
            dp[0][j] = dp[0][j-weights2[0]]+values2[0];
        }

        // 二重循环  可以先遍历物品，也可以先遍历重量，都可
        // 先遍历物品  从第一个开始，因为第0个物品的情况已经初始化过了
        for (int i = 1; i <n; i++) {
            // 再循环重量（也就是背包容量），要取到 w   正序循环
            for (int j = 0; j <= w; j++) {
                if(j<weights2[i])
                    dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] =Math.max(dp[i-1][j],dp[i-1][j-weights2[i]]+values2[i]);
                }
            }
        }
        System.out.println(dp[n-1][w]);
    }

    //  ======================一维数组写法================================

    private void oneDimensionMethod(){
        int w = 4;
        int[] weights2 = {1,3,4};
        int[] values2 ={15,20,30};

        int n = weights2.length;

        // dp[j]  其中j为重量   dp[j] 表示重量为j的背包，其最大的价值
        int[] dp = new int[w+1];
        // 初始化
        dp[0]=0;
        // 如果给定的价值有负数，则其余非0下标都应该初始化为负无穷   Integer.MIN_VALUE
        // 以为循环时只能时先遍历物品，因为如果先遍历重量，那相当于给背包只放了一个物品
        // 而且一维数组的循环，物品从0开始
        for (int i = 0; i <n ; i++) {
            // 在一维数组时，循环重量必要时倒序遍历 ，为了防止正序时多次放入
            for (int j = w; j >=weights2[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-weights2[i]]+values2[i]);
            }
        }
        System.out.println(dp[w]);
    }

}
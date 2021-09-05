package com.practice;



/**
 * @author Lincoln
 * @classname Main
 * @description 用来作为牛客和赛码网笔试题的模板
 * @params
 * @return
 * @date 2020/7/15 16:32
 */

import java.io.*;
import java.util.*;

class Solution {
    /* Write Code Here */
    private static int[][] f;
    private static List<String> ans = new ArrayList<String>();
    private static int n;
    private static int res = 0;
    public static int partitionNumber(String text) {
        n = text.length();
        f = new int[n][n];
        dfs(text, 0);
        return res;

    }
    public static void dfs(String s, int i) {
        if (i == n) {
            res ++;
            return;
        }
        for (int j = i; j < n; ++j) {
            if (longestDecomposition(s.substring(i,j+1)) >= 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static int longestDecomposition(String text) {
        int resultCount = 0;

        int n = text.length();
        int frontStringFrontIndex = 0;
        int frontStringRearIndex = 0;
        int rearStringFrontIndex = n - 1;
        int rearStringRearIndex = n - 1;

        int i, j;
        char charFront, charRear;
        boolean isValid;

        while(frontStringRearIndex < rearStringFrontIndex) {
            isValid = true;

            for (i = frontStringFrontIndex, j = rearStringFrontIndex; i <= frontStringRearIndex && j <= rearStringRearIndex; i++, j++) {
                charFront = text.charAt(i);
                charRear = text.charAt(j);
                if(charFront != charRear) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                resultCount += 2;
                frontStringFrontIndex = frontStringRearIndex + 1;
                frontStringRearIndex = frontStringFrontIndex;
                rearStringRearIndex = rearStringFrontIndex - 1;
                rearStringFrontIndex = rearStringRearIndex;
            } else {
                frontStringRearIndex++;
                rearStringFrontIndex--;
            }
        }

        if(frontStringFrontIndex <= rearStringRearIndex) {
            resultCount++;
        }

        return resultCount;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _text;
        try {
            _text = in.nextLine();
        } catch (Exception e) {
            _text = null;
        }

        res = new Solution().partitionNumber(_text);
        System.out.println(String.valueOf(res));

    }
}














//    public static void main(String[] args) {
//        int[] nums = {1,5,2,4,1};
//        System.out.println(minOperations(nums));


//        int[][]points = {{1,1},{2,2},{3,3},{4,4},{5,5}};
//        int[][]queries = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};
//        for(int num :countPoints(points,queries))
//        System.out.println(num+ " ");


//        int[] nums = {0,1,1,3};
//        for(int num : getMaximumXor(nums,2)){
//            System.out.print("res= "+num+ " ");
//        }

//        String s = "abc";
//        System.out.println(makeStringSorted(s));

//        String s = "thequickbrownfoxjumpsoverthelazydog";
//        System.out.println(checkIfPangram(s));

//        int[] costs = {1,6,3,1,2,5};
//        System.out.println(maxIceCream(costs,20));


//        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
//        for(int num:getOrder(tasks)){
//            System.out.print(num+" ");
//        }

//        int[] arr1 = {12};
//        int[] arr2 = {4};
//        System.out.println(getXORSum(arr1, arr2));

//    }
/**
 (a&b1)^(a&b2) =  a&(b1^b2)
 * */
//    public static int getXORSum(int[] arr1, int[] arr2) {
//        int sum1 = 0;
//        int sum2 = 0;
//        for (int i : arr1) {
//            sum1 ^= i;
//        }
//        for (int i : arr2) {
//            sum2 ^= i;
//        }
//        return sum1 & sum2;
//    }

//    public static int getXORSum(int[] arr1, int[] arr2) {
//        int n1 = arr1.length;
//        int n2 = arr2.length;
//        int[] arr3 = new int[n1*n2];
//        int index=0;
//        for(int i =0;i<n1;i++){
//            for(int j=0;j<n2;j++){
//                arr3[index++]= arr1[i]&arr2[j];
//            }
//        }
//        int res = arr3[0];
//        for(int i=1;i<arr3.length;i++){
//            res = res^arr3[i];
//        }
//        return res;
//    }
//    public static int[] getOrder(int[][] tasks) {
//        int[] ans = new int[tasks.length];
//        Integer[] arr = new Integer[tasks.length];    // 用于记录 任务开始时间从大到小的数组
//        for (int i = 0; i < arr.length; i++) arr[i] = i;
//        Arrays.sort(arr, (a, b) -> tasks[a][0] - tasks[b][0]); //这边是对 arr 按照任务开始时间从大到小的排序
//        // queue 存的整数，也就是存的是任务的序号，但是排列的顺序是按照任务的持续时间和下标来排的
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                if (tasks[a][1] > tasks[b][1]) return 1;  //任务时间长的 放后面
//                else if (tasks[a][1] == tasks[b][1]) return a - b; //当任务时间相同时，按照序号大小排序
//                return -1;
//            }
//
//        });   //定义一个优先队列
//        int j = 0; // 最终的结果
//        int i = 0; // 表示已经往准备队列里加入了多少任务
//        // arr 已经按照开始时间的大小进行排序  arr[0] 可能是第n个任务
//        int time = tasks[arr[0]][0];  //定义一个时间线 （这边卡了很久。。）
//        while (queue.size() != 0 || i < tasks.length) {
//            if (queue.size() == 0) {  //如果队列为空  就把下一个开始时间的所有任务都加进来
//                //比如 用例 [[7,10],[7,12],[7,5],[7,4],[7,2]] 。
//                int k = tasks[arr[i]][0];
//                while (i < tasks.length && tasks[arr[i]][0] == k) queue.add(arr[i++]);
//            } else { //队列 不为空
//                int index = queue.poll();  // index 是第几个任务
//                time += tasks[index][1];  //时间线 time 要加上 任务执行后 时间线 走到哪了
//                ans[j++] = index;
//                while (i < tasks.length) {
//                    // 到当前任务结束之前，该加入的都加入
//                    if (tasks[arr[i]][0] <= time) queue.add(arr[i++]); //把开始时间 小于time的都加入到队列
//                    else break;
//                }
//            }
//        }
//        return ans;
//
//    }

//    public static int[] getOrder(int[][] tasks) {
//        int n = tasks.length;// 任务的个数
//        if (n <= 1) return new int[]{0};
//        // 带上是第几个任务 这个信息
//        int[][] newTasks = new int[n][3];
//        for (int i = 0; i < n; i++) {
//            newTasks[i][0] = tasks[i][0];
//            newTasks[i][1] = tasks[i][1];
//            newTasks[i][2] = i;
//        }
//        // 将原来的任务列表转变为输入时刻的任务列表
//        PriorityQueue<int[]> inputQueue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0]; // 递增的写法
//            }
//        });
////        PriorityQueue<I> testQueue = new PriorityQueue<>();
//        // 待执行的任务列表
//        PriorityQueue<int[]> prepareQueue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1] == o2[1]) {
//                    return o1[2] - o2[2];   // 执行时间相同的情况下，按照序号
//                } else {
//                    return o1[1] - o2[1];   // 按照执行时间由小到大
//                }
//            }
//        });
//        // 将原有任务队列排序
//        for (int i = 0; i < n; i++) {
//            inputQueue.add(newTasks[i]);
//        }
//
////        // newTasks = [1,2,0]   1开始  需要两秒 是第0个任务
//        int time = 0;
//        boolean status = false;   // false为空闲，true为正在执行
//        int taskTimeRemain = 0;      // 该任务剩余执行时间
//        int index = 0;
//        int[] res = new int[n];
//        while (!inputQueue.isEmpty() || !prepareQueue.isEmpty()) {
//            // 当时间到了以后，把输入队列相关时间开始的，都放入准备对流
//            while (!inputQueue.isEmpty() && inputQueue.peek()[0] == time) {
////                System.out.println("==="+inputQueue.peek()[2]);
//                prepareQueue.add(inputQueue.poll());
//            }
//            if (taskTimeRemain == 0) { //执行完上一个，状态转为空闲
//                status = false;
//            }
//            if (!prepareQueue.isEmpty() && status == false) {
//                taskTimeRemain = prepareQueue.peek()[1];
//                res[index++] = prepareQueue.poll()[2];
//                status = true;
//            }
//            time++;
//            if (taskTimeRemain > 0) {
//                taskTimeRemain--;
//            }
//
//        }
//        return res;
//    }


//    public static  int maxIceCream(int[] costs, int coins) {
//        Arrays.sort(costs);
//        int n = costs.length;
//        int res =0;
//        int sum=0;
//        for(int i =0;i<n;i++){
//
//            sum +=costs[i];
//
//            if(sum>coins){
//                break;
//            }
//            res++;
//        }
//        return res;
//    }

//    public static boolean checkIfPangram(String sentence) {
//        int n = sentence.length();
//        if (n < 26) return false;
//        boolean[] res = new boolean[26];
//        for (int i = 0; i < n; i++) {
//            int index = sentence.charAt(i) - 'a';
//            if (res[index] == false) {
//                res[index] = true;
//            }else {
//                continue;
//            }
//        }
//        for(int i=0;i<26;i++){
//            if(res[i]==false){
//                return false;
//            }
//        }
//        return true;
//    }

//    public static int makeStringSorted(String s) {
//        int length = s.length();
//        if(length<=1) return 0;
//        return 1;
////        return calRes(s);
//
//
//    }
//    public  static  int calRes(String s){
//        int ans=0;
//        int length =s.length();
//        if(length<=1) return 0;
////        while()
//        if(isRight(s)){
//            return ans + calRes(s.substring(0,length-1));
//        }else{
//            return ans + calRes(s.substring(0,length-1));
//        }
//
//    }
//    public static boolean isRight(String s){
//        int n = s.length();
//        for(int i=s.length()-1;i>=0;i--){
//            if(s.charAt(n-1)<s.charAt(i)){
//                return  false;
//            }
//        }
//        return true;
//    }


//    public static  int[] getMaximumXor(int[] nums, int maximumBit) {
//        int max = (int)Math.pow(2,maximumBit);
//        int n = nums.length;
//        int[] ans = new int[n];
//        int[] XorRes =new int[n];
//        XorRes[0] = nums[0];
//        int res =nums[0];
//        for(int i=1;i<n;i++){
//            res = res^nums[i];
//            XorRes[i] = res;
//        }
//        int t =n;
//        while(t>0){
//            if(t==n){ // 算第一个的时候
//                int res2 = XorRes[t-1];
////            System.out.println("res2="+res2);
//                int tempRes =0;
//                int tempMax =res2 ^tempRes;
//
//                for(int i=1;i<max;i++){
//                    if(tempMax < (res2^i)){
//                        tempMax = (res2^i);
//                        tempRes =i;
//                    }
//                }
////            System.out.println("tempRes="+tempRes);
//                ans[n-t] = tempRes;
//                t--;
//            }else{
//                int tempRes = nums[t]^ans[n-t-1];
//                if(tempRes <max){
//                    ans[n-t] = tempRes;
//                }else{
//                    int res2 = XorRes[t-1];
////            System.out.println("res2="+res2);
//                    tempRes =0;
//                    int tempMax =res2 ^tempRes;
//                    for(int i=1;i<max;i++){
//                        if(tempMax < (res2^i)){
//                            tempMax = (res2^i);
//                            tempRes =i;
//                        }
//                    }
//                    ans[n-t] = tempRes;
//                }
//                t--;
//            }
//
//        }
//        return ans;
//    }
//    public static int minOperations(int[] nums) {
//        if(nums.length==1){
//            return 0;
//        }
//        int count=0;
//        for(int i=1;i<nums.length;i++){
//            while(nums[i]<=nums[i-1]){
//                nums[i]++;
//                count++;
//            }
//        }
//        return count;
//    }
//    public static int[] countPoints(int[][] points, int[][] queries) {
//        int length = queries.length;
//        int dotLength = points.length;
//        int[] ans = new int[length];
//        for(int i=0;i<length;i++){
//            for(int j=0;j<dotLength;j++){
//                if(distance(points[j],queries[i])){
//                    ans[i]++;
//                }
//            }
//        }
//        return  ans;
//
//    }
//    public static boolean distance(int[] point,int[] center){
//        if(Math.sqrt((Math.pow((point[0]-center[0]),2))+Math.pow((point[1]-center[1]),2)) <= (double)center[2]){
//            return true;
//        }
//        return false;
//    }
//}



package com.practice;

import com.imooc.array.A;

import javax.xml.bind.SchemaOutputResolver;
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


public class practice2   {

    public static void main(String[] args) {


//      System.out.println( ++demo2.i );//编译失败


//        System.out.println(new practice2().compressString("aabcccccaaa"));
//        int[] p  =  {4,2,1};
//        System.out.println(new practice2().petalsBreak(p));
//        int[][]rooms= {{-2,-3,3},{-5,-10,1},{10,30,-5}};
//        int[] start = {0,0};
//        int[] end  ={2,2};
//        System.out.println(new practice2().minimumInitHealth(rooms, start, end));
//        String str = "abc"+ new String("def");
//        //        System.out.println(str);
//        String str1 = "def";
//        String str2 = "abcdef";
//        String str3 = "abc"+"def";
//        String str33 = "abc"+str1;
//        String str4 = new String("abcdef");
//        System.out.println(str33==str2);

//        Map<Integer,Character> map   =  new HashMap<>();
//        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();

//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[][] nums0 = new int[N][2];
//        for(int i=0;i<N;i++){
//            nums0[i][0] = sc.nextInt();
//            nums0[i][1] = sc.nextInt();
//        }
//
//        int[][] nums = {{2,3},{1,9},{4,10},{5,20}};
//        int[][] nums1 = {{1,3},{4,5},{7,10},{13,18}};
//        System.out.println(findbaohan(nums1));
//        Scanner sc = new Scanner(System.in);
//        int[] nums = new int[10];
//        for(int i=0;i<10;i++ ){
//            nums[i] = sc.nextInt();
//        }

//        int[] nums = {0,1,0,0,1,1,1,1,2,2};
//        System.out.println(calculateMax(nums));

//       int[] nums ={10,11,12,13,1};
//       System.out.println(findDuiZi(nums));
//         int[][] books = {{20210427,20210504},{20210425,20210504},{20210425,20210504},{20210425,20210501},{20210425,20210501},{20210427,20210502}};
//         int[][] books2 ={{20210425,20210504}};
//        System.out.println(sort(books2));
//        Stack<Integer> in = new Stack<>();

//        Integer initBbj = Integer.valueOf(args[args.length-1]);
//        int i  = initBbj.intValue();
//        System.out.println(args.length);
//        String a ="a";
//        Integer b = 1;
//        System.out.println(calTime());
//        System.out.println(Math.min(Integer.MAX_VALUE+1,10));
//        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
//        System.out.println(getMaximumResource(grid));
//        ArrayList<Integer> list = new ArrayList<>();
//        list.size();
//        System.out.println(0b10); // 2进制
//        System.out.println(010);  // 8进制
//        System.out.println(10);  // 10进制
//        System.out.println(0x10); // 16进制
//        int[][] grids ={{1, 1, 1, 2}};
//        System.out.println(new practice2().categoryOfMaxWarehouseArea(grids));
//        System.out.println(Arrays.toString(numberOfShelves(4)));
//          int[] index = {1,1,2, 2,2,2,2,1, 1, 2, 2, 2, 2,2};
//          int k = 2;
//          int n = index.length;
//          test1(index,n,k);
//        System.out.println(Integer.toBinaryString('0'));
//        test222();
//        System.out.println(NS_String("cbcb",2));
//          long[] a = FarmerNN(4,6);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//        System.out.println(test2212(4,11));
//        System.out.println("aa");
//        System.out.println("aa"+('b'));
//        test2021082201();
//        System.out.println(test08251());
//        test08252();
//        test08261();
//          test08292();
//          test0829202();
//          test0829302();
//        test08301();
//        int[] nums = {5,3,2,7,2,1};
//        for (int i = 0; i <5 ; i++) {
//            System.out.println("i="+i+  " " +Arrays.toString(deleteM(nums,i)));
//        }
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(getMoney(i));
//
//        }
//        test09041();
//        test09042("merchant");
        test09051();

    }



    public static  void test09051(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
        }

//        int k =1;
//        int[] times = {1,2,3,4};
//        int n =times.length;
        int totalTime = n*(n-1)/2;
        int count = 0;
        int[] sums = new int[n];
        sums[0] = times[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i-1]+times[i];
        }
        for(int i =0;i<n;i++){

        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(times[j]-times[i]<=k){
                    count++;
                }
            }
        }
        if(count==0) {
            System.out.println(0);
            return;
        }else if(count ==totalTime){
            System.out.println(1);
            return;
        }else{
            int num = findGongYueShu(count,totalTime);
            if(num!=1){
                count = count/num;
                totalTime = totalTime/num;
            }
            System.out.println(count+"/"+totalTime);
        }



    }

    public  static int findGongYueShu(int i,int j){
        int res= i>j? j:i;
        while(i%res!=0 || j%res!=0){
            res--;
        }
        return res;
    }

    public  static int findGongYueShu2(int num1,int num2){
        int temp = num1 % num2;
        while (temp != 0) {
            num1 = num2;
            num2 = temp;
            temp = num1 % num2;
        }
        return num2;
    }




    public static  void test09042(String text){

        int res = divide(text,0);
        System.out.println(res);

    }
    public static  int divide(String text,int n){
        int m = text.length();
        if(text.equals("")) return n;
        for(int i=0;i<m/2;i++){
            if(text.substring(0,i+1).equals(text.substring(m-i-1,m))){
                return divide(text.substring(i+1,m-i-1),n+2);
            }
        }
        return n+1;
    }



    public static  void test09043(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1){
            System.out.println(0);
            return;
        }
        int k = sc.nextInt();
        int[][] nums = new int[n-1][3];
        for(int i=0;i<n-1;i++){
            nums[i][0] =sc.nextInt();
            nums[i][1] =sc.nextInt();
            nums[i][2] =sc.nextInt();
        }


        System.out.println(8);


    }
    static int[][] sums;
    public  static  void test09041(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0) {
            System.out.println(0);
            return ;
        }
        int[][] nums = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums[i][j] = sc.nextInt();
            }
        }
//        int n=3;
//        int[][] nums = {{1 ,2, -3},{ 3, 4, -5},{-5, -6, -7}};
        sums = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            int rowSum =0;
            for(int j=0;j<n;j++){
                rowSum+=nums[i][j];
                sums[i+1][j+1] = sums[i][j+1]+rowSum;
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;i+k<n;k++){
                    for(int l=0;j+l<n;l++){
                        System.out.println("i="+i+" j="+j+" m="+(i+k)+" n="+(j+l));
                        res = Math.max(sumRegion(i,j,i+k,j+l),res);
                        System.out.println(res);
                    }
                }
            }
        }
        System.out.println(res);
    }
    public static int sumRegion(int r1,int c1,int r2,int c2){
        return sums[r2+1][c2+1]-sums[r1][c2+1]-sums[r2+1][c1]+sums[r1][c1];
    }

    public  static void test09012(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res =4;

        System.out.println(res);
    }


    public  static void test09011(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] nums = input.split(",");
        int m = Integer.parseInt(nums[0].split("=")[-1]);
        int n = Integer.parseInt(nums[1].split("=")[-1]);
        int[] a = new int[m+n];
        int[] b = new int[n];
        String s1 = sc.nextLine();
        String[] str1 = s1.split(",");
        String s2 = sc.nextLine();
        String[] str2 = s2.split(",");
        for(int i=0;i<str1.length;i++){
            a[i] = Integer.parseInt(str1[i]);
        }
        for(int i=0;i<str2.length;i++){
            b[i] = Integer.parseInt(str2[i]);
        }
        int i = m-1;
        int j= n-1;
        int k = m+n-1;
        while(i>=0 || j>=0){
            if(j>=0 && ((i>=0 && b[j]>a[i])||i<0)){
                a[k] =b[j];
                --j;
                --k;
            }else if(i>=0){
                a[k] = a[i];
                --i;
                --k;
            }
        }
        System.out.println(Arrays.toString(a));


    }


    public static  int getMoney(int n){
        int sum=0;
        int day =0;
        int i=1;
        while(sum+i<=n){
            sum+=i*i;
            day+=i;
            i++;
        }
        while(day<n){
            sum+=i;
            day++;
        }
        return sum;
    }


    public static int[] deleteM(int[] nums,int m){
        int n = nums.length;
        int tpm = m;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i=0;i<n;i++){
            int temp = nums[i];
            while (!deque.isEmpty() && m>0 && deque.peekLast() < temp){
                deque.pollLast();
                m--;
            }

            deque.offerLast(temp);


        }
        for(int i=0;i<m;i++){
            deque.pollLast();
        }
        int[] res =new int[n-tpm];
//        System.out.println("deque.size="+deque.size());
        for(int i=0;i<n-tpm;i++){
            int temp = deque.pollFirst();
//            System.out.println("tempp="+temp);
            res[i] = temp;
        }
        return res;
    }



    public static  void test083022(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] dest  = new int[m][3];

        for(int i=0;i<m;i++){
            for(int j=0;j<3;j++){
                dest[i][j] = sc.nextInt();
            }
        }
        int[][] route = new int[q][2];

        for(int i=0;i<q;i++){
            for(int j=0;j<2;j++){
                route[i][j] = sc.nextInt();
            }
        }



        for(int i=0;i<q;i++){
            int start = route[i][0];
            int end = route[i][1];
            int ai= calAi2(start,end,dest);
            System.out.println(ai);
        }

    }
    public static int calAi2(int start,int end,int[][] dest){
        int res =0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int tempStart = queue.poll();
            for(int i=0;i<dest.length;i++){
                if(dest[i][0]==tempStart){
                    queue.add(dest[i][1]);
                    res = Math.max(res,dest[i][2]);
                    if(dest[i][1]==end){
                        return res;
                    }
                }
            }
        }
        return res;
    }






    public static  void test08302(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] dest  = new int[m][3];

        for(int i=0;i<m;i++){
            for(int j=0;j<3;j++){
                dest[i][j] = sc.nextInt();
            }
        }
        int[][] route = new int[q][2];

        for(int i=0;i<q;i++){
            for(int j=0;j<2;j++){
                route[i][j] = sc.nextInt();
            }
        }

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<m;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(dest[i][1]);
            temp.add(dest[i][2]);
            map.put(dest[i][0],temp);
        }

        for(int i=0;i<q;i++){
            int start = route[i][0];
            int end = route[i][1];
            int ai= calAi(start,end,map);
            System.out.println(ai);
        }

    }
    public static int calAi(int start,int end,HashMap<Integer,List<Integer>> map){
        int res =0;
        while(start!=end){
            res = Math.max(res,map.get(start).get(1));
            start =map.get(start).get(0);
        }
        return res;
    }


    public static  void  test08301(){
        Scanner sc = new Scanner(System.in);
//        int[] factor = new int[5];
//        for(int i=0;i<5;i++){
//            factor[i] =sc.nextInt();
//        }
//        int n = sc.nextInt();
//        int[][] score = new int[n][5];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<5;j++){
//                score[i][j] = sc.nextInt();
//            }
//        }
        int[] factor = {1,1,1,1,1};

        int n=4;
        int[][] score ={{5 ,6 ,6 ,2, 0},{5 ,5, 6, 2 ,1},{2 ,2 ,2 ,4, 5},{9, 0 ,0, 2, 1}};

        int[] totalScore = new int[n];
        for(int i=0;i<n;i++){
            for(int j =0;j<5;j++){
                totalScore[i] += (factor[j]*score[i][j]);
            }
        }
        int maxRes = 0;
        for(int i=0;i<n;i++){
            if(maxRes<totalScore[i]){
                maxRes = totalScore[i];
            }
        }
        System.out.println(maxRes);
        int count =0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(totalScore[i]==maxRes){
                list.add(i);
                count++;
            }
        }
        System.out.println("count="+count);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)+1);
        }



    }

    public static  void  test0829302(){
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String a = sc.nextLine();
        String s ="meituaniirf";
        String a ="iuii";
        int n =s.length();
        int m =a.length();

        int i=0;
        int count =0;
        while(i<m){
            int j = 0;
            while(j<n){
                if(s.charAt(j)==a.charAt(i)){
                    i++;
                    System.out.println("j="+j);
                }
                if(i>=m){
                    System.out.println(count*n+j+1-m);
                    return ;
                }
                j++;
            }
            count++;
        }


    }

    public static  void  test08293(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String a = sc.nextLine();
        int n =s.length();
        int m =a.length();


        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),i);
        }
        for(int i=0;i<m;i++){
            if(!map.containsKey(a.charAt(i))){
                System.out.println(-1);
                return;
            }
        }
        int count=0;
        int[] index = new int[m];
        for(int i=0;i<m;i++){
            index[i]= map.get(a.charAt(i));
        }
        int pre =0;
        int res =0;
        for(int i=0;i<m;i++){
            if(index[i]>pre){
                res +=(index[i]-pre);
                pre = index[i];
            }else{
                res += (n-pre-1+index[i]);
                pre = index[i];
            }
        }


    }
    public static void test0829202(){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[n];
//        for(int i=0;i<n;i++){
//            a[i] =sc.nextInt();
//        }
//        for(int i=0;i<n;i++){
//            b[i] =sc.nextInt();
//        }

        int[] a= {1, 2, 3, 4,4,7,8,9,10,5,5,4,2,1};
        int[] b= {1, 3, 3, 4,7,8,8,9,10,4,3,6,7,3};
        int n= a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        int[] c= new int[n];
        for (int i = 0; i < n; i++) {
            int count =0;
            for (int j = 0; j <n ; j++) {
                if(b[j]>=a[i])count++;
            }
            c[i]=count;
        }
        int res =1;
        int mod = 1_000_000_007;
        for (int i=n-1;i>=0;i--){
            int count = c[i]-(n-1-i);
            res = res*count;
        }
        System.out.println(res);

    }




    public static void test08292(){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[n];
//        for(int i=0;i<n;i++){
//            a[i] =sc.nextInt();
//        }
//        for(int i=0;i<n;i++){
//            b[i] =sc.nextInt();
//        }

        int[] a= {1, 2, 3, 4,4,7,8,9,10,5,5,4,2,1};
        int[] b= {1, 3, 3, 4,7,8,8,9,10,4,3,6,7,3};
        int n = a.length;
        int mod = 1_000_000_007;
        boolean[] flag = new boolean[n];
        Arrays.sort(a);
        Arrays.sort(b);
        int res =0;
        res=new practice2().dfs(a,b,flag,0,mod);
        System.out.println(res);

    }
    int res1 =0;
    public  int dfs(int[] a,int[] b,boolean[] flag, int start,int mod){
        if(start==a.length ){
            res1+=1;
            res1%=mod;
            return res1 ;
        }
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[start]<=b[i] && !flag[i]){
                flag[i]=true;
                dfs(a,b,flag,start+1,mod);
                flag[i]=false;
            }
        }
        return res1;
    }







    public static void test08291(){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for(int i=0;i<n;i++){
//            nums[i] =sc.nextInt();
//        }
        int n=10;
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 3, 3, 1};
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        int res =0;
        for(int i=1;i<n;i++){
            int temp = nums[i];
            res += count(map,temp);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        System.out.println(res);

    }
    public static int count(HashMap<Integer,Integer> map,int num){
        int res=0;
        for(int i=0;i<num;i++){
            if(map.containsKey(i)){
                res+=1;
            }
//            res += map.getOrDefault(i,0);
        }
        System.out.println("temp="+num+" res="+res);
        return res;
    }




    public static void test08261(){
//        Scanner sc = new Scanner(System.in);
//        String pattern = sc.nextLine();
//        String hayStack = sc.nextLine();
        String pattern = "";
        String hayStack = "alb1albanialbaalbaniarfgh";
        int res = strStr(hayStack,pattern);
        System.out.println(res==-1? "Not found":"Found at: "+res);


    }
    public static  int strStr(String haystack, String needle) {
        if (needle.length() == 0) {

            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        // needle作为模式字符串，求出其前缀表
        int[] next = getNext(needle);
        System.out.println(Arrays.toString(next));
        // 初始化 前缀末尾的指针
        int j = 0;
        // 遍历文本串
        for (int i = 0; i < haystack.length(); i++) {
            //如果不相等，从next数组中找下一个开始匹配的位置
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
                System.out.println(j);
            }
            //如果相等，j++  i++  （i在for循环中++）
            if (haystack.charAt(i) == needle.charAt(j)) {
                System.out.println(j);
                j++;
            }
            // j等于模式串的长度，说明完全匹配到一个相等的字符串，此时从i+1减去模式串长度就是起始第一个匹配的位置
            if (j == needle.length()) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    private static int[] getNext(String s){
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

    public static void test08252() {
        Scanner sc = new Scanner(System.in);



        List<List<Integer>> list = new ArrayList<List<Integer>>();

        int row =0;
        while(sc.hasNext() && row<3){
            String sb=sc.nextLine();
            row++;
            String[] sbs = sb.split(",");
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=0;i<sbs.length;i++){
                temp.add(Integer.parseInt(sbs[i]));
            }
            list.add(temp);
        }
        int col = list.get(0).size();
        int[][] nums = new int[row][col];
        for(int i=0;i<list.size();i++){
            List<Integer> temp = list.get(i);
            for(int j=0;j<temp.size();j++){
                nums[i][j] = temp.get(j);
            }
        }
//        int[][] nums = {{1,1,0,0},
//                        {1,1,0,0},
//                        {1,0,1,0},
//                        {1,1,0,1}};

        int res =0;
        System.out.println(Arrays.deepToString(nums));
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==1){
                    res++;
                    traceBack(nums,i,j);
                }
            }
        }
        System.out.println(res==0? -1: res);


    }
    public static void traceBack(int[][] nums,int i,int j){
        if(i<0 || j<0 || i>=nums.length || j>= nums[0].length || nums[i][j]==0){
            return ;
        }
        nums[i][j] = 0;
        traceBack(nums,i+1,j);
        traceBack(nums,i-1,j);
        traceBack(nums,i,j+1);
        traceBack(nums,i,j-1);
    }





    public static int test08251() {
        Scanner sc = new Scanner(System.in);

        String sb = new String();

        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();

        int row =0;
        while(sc.hasNext()){
            sb=sc.nextLine();
            row++;
            String[] sbs = sb.split(",");
            for(int i=0;i < sbs.length;i++){
                map.put(Integer.parseInt(sbs[i].trim()),map.getOrDefault(Integer.parseInt(sbs[i].trim()),0)+1);
            }
        }

        int res = -1;
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                return entry2.getValue()==entry1.getValue()? entry1.getKey()-entry2.getKey(): entry2.getValue()-entry1.getValue();
            }
        });

        if(list.get(0).getValue()==row){
            return list.get(0).getKey();
        }else{
            return -1;
        }
    }





    public static void test2021082201(){
        int m = 6;
        int n =3;
        String target = "ABCDEA";
        String[] strs = {"AAAAAA","BBBBBB","ABDDEB"};
        int[] scores = new int[n];
        Arrays.fill(scores,Integer.MAX_VALUE);

        for(int i=0;i<n;i++){
            if(check(target,strs[i])){
                scores[i] = calScore(target,strs[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <n ; i++) {
            if(min>scores[i]){
                min =scores[i];
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println("None");
            return;
        }
        for(int i=0;i<n;i++){
            if(scores[i]==min){
                System.out.println(strs[i]);
            }
        }


    }
    public static boolean check(String str1,String str2){
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        for(int i =0;i<array1.length;i++){
            char temp1 = array1[i]<=array2[i]? array1[i]:array2[1];
            char temp2 = array1[i]<=array2[i]? array2[i]:array1[1];
            if((temp2=='E'&& (temp1=='A'|| temp1=='B' || temp1=='C')) ||(temp1=='B' && temp2=='D')){
                return false;
            }
        }
        return true;
    }
    public static int calScore(String str1,String str2){
        int res =0;
        for(int i=0;i<str1.length();i++){
            res +=Math.abs(str1.charAt(i)-str2.charAt(i));
        }
        return res;
    }






    public int minSailCost (int[][] input) {
        // write code here
        int row = input.length;
        int col = input[0].length;
        int max = Integer.MAX_VALUE/10;
        int[][] cost = new int[row][col];
        cost[0][0] = 0;
        for(int i =1;i<row;i++){
            if(input[i][0]==0){
                cost[i][0] =2+cost[i-1][0];
            }else if(input[i][0]==1){
                cost[i][0] = 1+cost[i-1][0];
            }else{
                cost[i][0] = max+ cost[i-1][0];
            }
        }
        for (int i = 1; i < col; i++) {
            if (input[0][i] == 0) {
                cost[0][i] = 2 + cost[0][i-1];
            } else if (input[0][i] == 1) {
                cost[0][i] = 1 + cost[0][i-1];
            } else {
                cost[0][i] = max + cost[0][i-1];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (input[i][j] == 0){
                    cost[i][j] = 2 + Math.min(cost[i-1][j], cost[i][j-1]);
                } else if (input[i][j] == 1) {
                    cost[i][j] = 1 + Math.min(cost[i-1][j], cost[i][j-1]);
                } else {
                    cost[i][j] = max + Math.min(cost[i-1][j], cost[i][j-1]);
                }
                System.out.println("i:" + i + "j:" + j + "  "+cost[i][j]);
            }
        }
        if (cost[row-1][col-1] >= max){
            return -1;
        } else {
            return cost[row-1][col-1];
        }

    }


    public static void test332(){
        Scanner sc = new Scanner(System.in);
        String s =  sc.nextLine();
        String[] numStr = s.split(" ");
        int[] nums = new int[numStr.length];
        int n = nums.length;
        for (int i=0;i<n;i++){
            nums[i] = Integer.parseInt(numStr[i]);
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                left[i]= left[i-1]+1;
            }
        }
        int count = left[n-1];
        for (int i = n-2; i >=0; i--) {
            if(nums[i]>nums[i]+1){
                right[i] =right[i+1]+1;
            }
            count += Math.max(left[i],right[i]);

        }
        System.out.println(count);
    }



    public static void test333() {
        Scanner sc = new Scanner(System.in);
        String s =  sc.nextLine();
        String[] numStr = s.split(" ");
        int[] nums = new int[numStr.length];
        int n = nums.length;
        int count=0;
        int[] res = new int[n];
        Arrays.fill(res,1);
        if(nums[0]>nums[n-1]){
            res[0]=res[n-1]+1;
        }
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                res[i]=res[i-1]+1;
            }
        }

        for(int i =n-2;i>0;i--){
            if(nums[i-1]>nums[i] &&(res[i-1]<=res[i])){
                res[i-1]=res[i]+1;
            }
        }
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum+=res[i];
        }
        System.out.println(sum);
    }

    public static char test2212( int n, int k){
        if(n==1) return 'a';
        int i=2;
        String temp = "a";
        String ans= "";
        while(i<=n){
            char[] array = temp.toCharArray();
            for(int j = 0;j<array.length;j++){
                System.out.println("ch1="+array[j]);
                array[j] = (char)('z'-array[j]+'a');
                System.out.println("ch2="+array[j]);
            }
            String invertStr = new String(array);
            System.out.println("invertStr="+invertStr);
            String reverseStr = new StringBuffer(invertStr).reverse().toString();
            ans = temp+(char)(i-1+'a')+reverseStr;
            System.out.println("ans="+ans);
            temp =ans;
            i++;
        }
        System.out.println("ans="+ans);
        return ans.charAt(k-1);
    }



    public  static int test111(){
        Scanner sc = new Scanner(System.in);
        String s =  sc.nextLine();
        int m = sc.nextInt();
        String[] numStr = s.split(" ");
        int[] nums = new int[numStr.length];
        for (int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(numStr[i]);
        }
        int count=0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if(nums[i]+nums[j]<m){
                    count++;
                }
            }
        }
        System.out.println(count);
        return 0;
    }

    public static  long section (int[] a, int t) {
        // write code here
        long res =0;
        int n = a.length;
        if(n<=1){
            return 0;
        }
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n-1;i++){
            if((a[i]^a[i+1])!=t){
                res++;
            }else{
                dp[i][i+1]=true;
            }
        }

        for(int i=2;i<n;i++){
            for(int j=0;j<n-i;j++){
                if((a[j]^a[j+i])!=t &&(!dp[j][j+i-1])&&(!dp[j+1][j+i])){
                    res++;
                }else{
                    dp[j][j+i]=true;
                }
            }
        }
        return res;


    }


    public static long[] FarmerNN (int n, long m) {
        // write code here

        long[] a = new long[n];
        long tempM = m-1;
        long row = tempM/(n-1);
        Arrays.fill(a,row);
        long last = (tempM%(n-1));
        m =last;
        if(row%2==0){
            while(true){
                int i=0;
                while(m>0 && i<n){
                    a[i]+=1;
                    i++;
                    m--;
                }
                if(m==0){
                    return a;
                }
                i=n-2;
                while(m>0 && i>0){
                    a[i]+=1;
                    m--;
                    i--;
                }
                if(m==0){
                    return a;
                }
            }
        }else if(row%2==1){
            while(true){
                int i=0;
                while(m>0 && i<n){
                    a[i]+=1;
                    i++;
                    m--;
                }
                if(m==0){
                    return a;
                }
                i=n-2;
                while(m>0 && i>0){
                    a[i]+=1;
                    m--;
                    i--;
                }
                if(m==0){
                    return a;
                }
            }
        }
        return a;
    }


    public static String NS_String (String s, int k) {

        // write code here
        if(k==0){
            return s;
        }
        HashMap<Integer, Character> map = new HashMap<>();
        char[] array = s.toCharArray();
        for(int i =0;i<array.length;i++){
            map.put(i,array[i]);
        }
        List<Map.Entry<Integer,Character>> list = new ArrayList<Map.Entry<Integer, Character>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> entry1, Map.Entry<Integer, Character> entry2) {
                return entry1.getValue()-entry2.getValue();
            }
        });

        char temp = list.get(0).getValue();
        int count =1;
        int i=1;
        while(count<=k){
            while(i<list.size() && (temp == list.get(i).getValue())){
                i++;
                System.out.println("temp="+temp);
            }
            if(i>=list.size()){
                return null;
            }
            temp = list.get(i).getValue();
            count++;
        }
        System.out.println("i="+i);
        List<Map.Entry<Integer,Character>> list2 = new ArrayList<Map.Entry<Integer, Character>>();
        for(int j =i;j<list.size();j++){
//            System.out.println("list2.value="+list.get(j).getValue());
            list2.add(list.get(j));
        }
//        for(int b=0;b<list2.size();b++){
//            System.out.println(list2.get(b).getValue());
//        }
        Collections.sort(list2, new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> entry1, Map.Entry<Integer, Character> entry2) {
                return entry1.getKey()-entry2.getKey();
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int m=0;m<list2.size();m++){
            sb.append(list2.get(m).getValue());
        }
        return sb.toString();


    }

    public static void test222(){
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
        String s ="306";
        char[] digits = new char[11];
        digits[0] = 0x3f;
        digits[1] = 0x06;
        digits[2] = 0x5b;
        digits[3] = 0x4f;
        digits[4] = 0x66;
        digits[5] = 0x6d;
        digits[6] = 0x7d;
        digits[7] = 0x07;
        digits[8] = 0x7f;
        digits[9] = 0x6f;
        digits[10] = 0x00;
        int n = s.length();
        if(n==0){
            return;
        }else if(n==1){
            int count =0;
            System.out.println(transfer((char)0x3a,s.charAt(0),digits));
            return;
        }else if(n>1){
            int  cwd =1;  // 窗口大小
            while(cwd<=s.length()){
                int i =0;
                int j =i+cwd;
                int count =0;
                char[] nums = new char[cwd];
                Arrays.fill(nums,(char) 0x3a);
                while(j<=s.length()){
                    count +=calTransfer(s.substring(i,j),nums,digits);
                    nums = s.substring(i,j).toCharArray();

                    i++;
                    j++;
                }
                System.out.println(count);
                cwd++;
            }

        }
    }

    public static int calTransfer(String s1,char[] nums,char[] digits){
        int n = s1.length();

        char[] arr = s1.toCharArray();
        if(arr.length!=nums.length){
            System.out.println("error");
        }
        int count =0;
        for(int i=0;i<n;i++){
//            System.out.println("nums["+i+"]="+nums[i]+" arr["+i+"]="+arr[i]);
            count += transfer(nums[i],arr[i],digits);
        }
        return count;
    }

    public static int transfer(char num1,char num2,char[] digits){

//        System.out.println("num1="+num1+" num2="+num2);
//        System.out.println("0="+(int)'0');
//
        System.out.println(" ");
        System.out.println("originNum="+num1+" toNum="+num2);
        System.out.println("digits1="+digits[num1-'0']+" digits2="+digits[num2-'0']);
        System.out.println("digits1="+Integer.toBinaryString(digits[num1-'0'])+" digits2="+Integer.toBinaryString(digits[num2-'0']));
        int temp = (digits[num1-'0']^digits[num2-'0']);
//        System.out.println("temp="+Integer.toBinaryString(temp));
        int count =0;
        while(temp!=0){
            temp &=(temp-1);
            count++;
        }
        System.out.println("count ="+count);
        return count;

    }





    public static void test1(int[] index,int n,int k){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] index = new int[n];
//        for(int i=0;i<n;i++){
//            index[i] = sc.nextInt();
//        }

        int[] sum = new int[n];
        sum[0] = index[0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1]+index[i];
        }
        double maxAvg = 0;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for(int j=k;j<=n;j++){
            double tempAvg = 1.0*sum[j-1]/j;
            System.out.println("tempAvg0 ="+tempAvg);
            if(tempAvg>=maxAvg){
                maxAvg = tempAvg;
                maxLength = j;
                left = 0;
                right = j-1;
                System.out.println("i=0,j="+right);
                System.out.println("maxLength="+maxLength);
            }
        }
        System.out.println("===============================");
        for(int i=1;i<=n-k;i++){
            for(int j=i+k;j<=n;j++){
                int tempLength = j-i;

                double tempAvg = 1.0*(sum[j-1]-sum[i-1])/(j-i);
                System.out.println("i="+i+" j="+(j-1));
                System.out.println("tempLength="+tempLength);
                System.out.println("maxLength="+maxLength);
                System.out.println("tempAvg="+tempAvg);
                if(tempAvg>=maxAvg ){
                    if(tempAvg==maxAvg && tempLength>maxLength){
                        maxLength = tempLength;
                        maxAvg = tempAvg;
                        left =i;
                        right = j-1;
                    }else if(tempAvg>maxAvg){
                        maxLength = tempLength;
                        maxAvg = tempAvg;
                        left =i;
                        right = j-1;
                    }

                }
            }
        }
        System.out.println(left+" "+right);


    }

    // diyiti
    public String decompress (String str) {
        StringBuilder buf = new StringBuilder();
        Deque<Integer> stack =new LinkedList<>();
        int i =0;
        int j=0;
        int len = str.length();
        while(i<len){
            char c = str.charAt(i);
            if(c=='('){
                stack.push(buf.length());
                i++;
            }
            else if(c>='a' && c<='z'){
                buf.append(c);
                i++;
            }
            else if(c>='0' && c<='9'){
                j=i;
                while(i<len && str.charAt(i)>='0' && str.charAt(i)<='9'){
                    i++;
                }
                buf.append(repeat(buf.substring(buf.length()-1),Integer.parseInt(str.substring(j,i))-1));
            }
            else if(c==')'){
                i++;
                j=i;
                while(i<len && str.charAt(i)>='0' && str.charAt(i)<='9'){
                    i++;
                }
                buf.append(repeat(buf.substring(stack.pop()),Integer.parseInt(str.substring(j,i))-1));
            }
        }
        return buf.toString();// write code here
    }
    private String repeat(String str,int n){
        int i;
        StringBuilder ans;
        ans = new StringBuilder();
        for( i=0;i<n;i++){
            ans.append(str);
        }
        return ans.toString();
    }




    // dierti
    public int purchase (int[] nums, int budget) {
        int mod = 1_000_000_007;
        int ans =0;
        Arrays.sort(nums);
        int left =0,right = nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]>budget){
                right--;
            }else{
                ans+=(right-left);
                left++;
            }
            ans %=mod;
        }
        return ans%mod;
        // write code here
    }


    //  disanti
    public int max_consistent_book_size (int[][] books) {
        // write code here
        if(books.length<1){
            return 0;
        }
        if(books.length==1){
            return 1;
        }
        Arrays.sort(books, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[0]==t2[0]){
                    return t1[1]-t2[1];
                }else{
                    return t1[0]-t2[0];
                }
            }
        });
        System.out.println(Arrays.deepToString(books));
        int n =books.length;
        int[] dp = new int[n];

        dp[1]=1;
        for(int i=1;i<n;i++){
            if(books[i][1]>=books[i-1][1]){
                dp[i] =dp[i-1]+1;
            }else{
                int j =i-1;
                while(j>=0){
                    if(books[i][1]>=books[j][1]){
                        dp[i] = Math.max(dp[i-1],dp[j]+1);
                        break;
                    }
                    if(books[i][0]>books[j][1]){
                        dp[i] =dp[i-1];
                        break;
                    }
                    j--;
                }
            }
        }
        return dp[n-1]+1;
    }


    // disiti
    public int[] numberOfShelves (int N) {
        // write code here
        if(N==1){
            return new int[]{1};
        }
        int[][] matrix = new int[N][N];
        int n = N;
        int bottom = n-1;
        int right = n-1;
        int top =0;
        int left =0;
        int num =1;
        while(top<=bottom && left <=right){
            for(int row= top;row<=bottom;row++){
                matrix[row][left] = num;
                System.out.println("row="+row+" col="+left+ " num="+num);
                ++num;
            }
            for(int col = left+1,row = bottom-1;col<=right && row>=0;col++,row--){
                matrix[row][col] = num;
                System.out.println("row="+row+" col="+col+ " num="+num);
                ++num;
            }
            for(int col = right-1;col>left;col--){
                matrix[top][col] = num;
                System.out.println("row="+top+" col="+col+ " num="+num);
                ++num;
            }
            System.out.println("============");
            top++;
            bottom-=2;
            left++;
            right-=2;
        }
        System.out.println(Arrays.deepToString(matrix));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    list.add(matrix[i][j]);
                }
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();

    }

    // diwuti
    public int categoryOfMaxWarehouseArea (int[][] grid) {
        // write code here

        int max = 0;
        int res =1;
        for (int i = 0; i < grid.length; i++) {
            for(int j =0;j<grid[0].length;j++){
                int target = grid[i][j];
                int temp = dfs(grid,i,j,target);
                System.out.println("target="+target+" res ="+temp);
                if(max <= temp ){
                    max = temp;
                    res = target;
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grids,int i,int j,int target){
        if(i<0 || j<0 || i>=grids.length || j>=grids[0].length || grids[i][j] !=target){
            return 0;
        }
        int temp = grids[i][j];
        grids[i][j]=0;
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        int ans =1;
        for(int index=0;index<4;++index){
            int next_i = i+di[index];
            int next_j = j+dj[index];
            ans+=dfs(grids,next_i,next_j,target);
        }
        grids[i][j] = temp;
        return ans;
    }





    // times   [start,end,port] [start,end,port] ....
    public int  Solution3(int[][] times){

        HashMap<Integer, Integer> map = new HashMap<>();
        // 直接指定一个固定的map.这样天然有序
        for(int i=0;i<24*3600;i++){
            map.put(i,0);
        }
        for(int i=0;i<times.length;i++){
            map.put(times[i][0],map.get(times[i][0])+1);
            map.put(times[i][1],map.get(times[i][0])-1);
        }

        int max = map.get(0);
        int temp =max;
        for(int i =1;i<map.size();i++){
            temp = map.get(i)+temp;
            max = Math.max(max,temp);
        }
        return max;
    }

    // times   [start,end,port] [start,end,port] ....
    public int  Solution2(int[][] times){

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<times.length;i++){
            map.put(times[i][0],map.getOrDefault(map.get(times[i][0]),0)+1);
            map.put(times[i][1],map.getOrDefault(map.get(times[i][1]),0)-1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                return entry1.getKey()-entry2.getKey();
            }
        });
        int max =list.get(0).getValue();
        int temp = max;
        for(int i =1;i<list.size();i++){
            temp = list.get(i).getValue()+temp;
            max = Math.max(max,temp);
        }
        return max;
    }


    // times   [start,end,port] [start,end,port] ....
    public int  Solution1(int[][] times){
        int res =0;
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0]-t2[0];
            }
        });
        int max = 0;
        for(int i=0;i<times.length;i++){
            res+=times[i][0];
            res -= times[i][1];
            max = Math.max(res,max);
        }
        return max;
    }



    public static int getMaximumResource (int[][] grid) {
        // write code here
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 && n==0 ){
            return 0;
        }
        int res = 0;
        boolean[][] flag = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    res = Math.max(start(grid,flag,i,j,0),res);
                }
            }
        }
        return res;
    }

    public static int start(int[][] grid,boolean[][] flag,int i, int j,int res){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || flag[i][j]==true){
            return res;
        }
        else{
            res += grid[i][j];
            flag[i][j] = true;
            int temp=res;
            res = Math.max(start(grid,flag,i+1,j,temp),start(grid,flag,i-1,j,temp));
            res = Math.max(start(grid,flag,i,j+1,temp),res);
            res = Math.max(start(grid,flag,i,j-1,temp),res);
            flag[i][j] = false;
            return res;
        }

    }


    public static int calTime(){
        Scanner sc = new Scanner(System.in);
        int max = 6;
//        int n = sc.nextInt();
//        int t1 = sc.nextInt();
//        max = Math.max(max,t1);
//        int t2 = sc.nextInt();
//        max = Math.max(max,t2);
//        int t3 = sc.nextInt();
//        max = Math.max(max,t3);
//        int t4 = sc.nextInt();
//        max = Math.max(max,t4);
//
//        int[] hs1 = new int[n];
//        for (int i = 0; i < n; i++) {
//            hs1[i] = sc.nextInt();
//        }

        int n = 6;
        int t1 = 1;
        int t2 = 4;
        int t3 = 3;
        int t4 = 1;
        int[] hs1 = {1,1,2,3,6,1};
        System.out.println("t1="+t1);
        System.out.println("t2="+t2);
        System.out.println("t3="+t3);
        System.out.println("t4="+t4);
        System.out.println(Arrays.toString(hs1));
        int[] hs2 = new int[n];
        for (int i = 0; i <n ; i++) {
            hs2[i] = 4-hs1[i];
        }

        int[][] dp = new int[n][2];
        for (int i = 1; i <n; i++) {
            // 相等
             if(hs1[i]==hs1[i-1]){
                 dp[i][0] = Math.min(dp[i-1][0]+t1,Integer.MAX_VALUE);
                 dp[i][1] = Math.min(dp[i-1][1]+t1,Integer.MAX_VALUE);
             }else if(hs1[i]>hs1[i-1]+1){ // 爬坡都爬不了
                 dp[i][0] = Integer.MAX_VALUE-max;
                 dp[i][1] = Math.min(dp[i-1][0]+t4+t3,dp[i-1][1]+t3);
             }else if(hs1[i]<hs1[i-1]-1) {  // 平行世界爬坡不了
                 dp[i][0] = Math.min(dp[i-1][0]+t3,dp[i-1][1]+t4+t3);
                 dp[i][1] = Integer.MAX_VALUE-max;
             }else if(hs1[i]==hs1[i-1]+1){ // 爬坡 1
                 dp[i][0] = Math.min(dp[i-1][0]+t2,dp[i-1][1]+t4+t2);
                 dp[i][1] = Math.min(dp[i-1][1]+t3,dp[i-1][0]+t4+t3);
             }else if(hs1[i] ==hs1[i-1]-1){ // 下跳
                 dp[i][0] = Math.min(dp[i-1][0]+t3,dp[i-1][1]+t4+t3);
                 dp[i][1] = Math.min(dp[i-1][1]+t2,dp[i-1][0]+t4+t2);
             }
        }
        return Math.min(dp[n-1][0],dp[n-1][1]);

    }

    public static  void test(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] pos = new int[n];
        for(int i=0;i<n;i++){
            pos[i] = sc.nextInt();
        }
        Stack<Integer> in = new Stack<Integer>();
        int max = 0;
        for(int i=1;i<n;i++){
            max = Math.max(max,pos[i]-pos[i-1]);
            in.push(pos[i]-pos[i-1]);
        }
        while(k>0){
            if(max==1){
                break;
            }
            Stack<Integer> out = new Stack<Integer>();
            boolean flag = false;
            while(!in.isEmpty()){
                int temp = in.pop();
                if(temp==max && !flag){
                    if(temp%2==1){
                        out.push(temp/2);
                        out.push(temp/2+1);
                        max =temp/2+1;
                        flag=true;

                    }else{
                        out.push(temp/2);
                        out.push(temp/2);
                        max =temp/2;
                        flag=true;

                    }
                }else{
                    out.push(temp);
                    max = Math.max(temp,max);
                }
            }
            while(!out.isEmpty()){
                in.push(out.pop());
            }
            k--;
        }
        System.out.println(max);

    }


    public static int sort(int[][] books){

        if(books.length<1){
            return 0;
        }
        if(books.length==1){
            return 1;
        }
        Arrays.sort(books, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[0]==t2[0]){
                    return t1[1]-t2[1];
                }else{
                    return t1[0]-t2[0];
                }
//                return t1[0]-t2[0];

            }
        });
        System.out.println(Arrays.deepToString(books));
        int n =books.length;
        int[] dp = new int[n];

        dp[1]=1;
        for(int i=1;i<n;i++){
            if(books[i][1]>=books[i-1][1]){
                dp[i] =dp[i-1]+1;
            }else{
                int j =i-1;
                while(j>=0){
                    if(books[i][1]>=books[j][1]){
                        dp[i] = Math.max(dp[i-1],dp[j]+1);
                        break;
                    }
                    if(books[i][0]>books[j][1]){
                        dp[i] =dp[i-1];
                        break;
                    }
                    j--;
                }
            }
        }
        return dp[n-1]+1;
    }


    public  static  boolean checkShuZuYouHua(int[] nums,int target){
        int i=0,j=0,sum=0;
        while(i<nums.length){
            while(sum<target && j<nums.length){
                sum+=nums[j];
                if(sum<target){
                    j++;
                }else if(sum==target){
                    return true;
                }else{
                    break;
                }
            }
            sum -=nums[i];
            i++;
        }

        return false;
    }

    public static  boolean checkZiShuZu(int[] nums,int target){

        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(sum==target){
                    return true;
                }else if(sum>target){
                    break;
                }
                sum+=nums[j];
            }
        }
        return false;
    }


    public static  boolean findDuiZi(int[] nums){
        Arrays.sort(nums);
        if(nums.length!=5){
            return false;
        }
        if(nums[0]==1){
            if(nums[4]==5){
                for(int i=1;i<5;i++){
                    if(nums[i]!=nums[i-1]+1){
                        return false;
                    }
                }
            }else if(nums[4]==13){
                for(int i=2;i<5;i++) {
                    if (nums[i] != nums[i - 1]+1) {
                        return false;
                    }
                }
            }else {
                return false;
            }
        }else {
            for(int i=1;i<5;i++){
                if(nums[i]!=nums[i-1]+1){
                    return false;
                }
            }
        }
        return true;

    }

    public static int calculateMax(int[] nums){
        int factor1 =0;
        int factor2 = 0;
        int res =0;
        int sum =0;
        for(int i=1;i<nums.length;i++) {
            sum += nums[i];
        }
        if(sum<=1){
            return 0;
        }
        int numZero = nums[0];
        // 为true 则给factor1加上
//        boolean firstFlag = true;

        for(int i=nums.length-1;i>=1;i--){
            while(nums[i]!=0){
                if(factor1==0 || factor2==0){
                    if(factor1==0){
                        factor1  = factor1*10+i;
                    }else{
                        factor2  = factor2*10+i;
                    }
                }else{
                    if(factor1<=factor2){
                        factor1  = factor1*10+i;
                    }else{
                        factor2  = factor2*10+i;
                    }
                }
                nums[i]--;
            }
        }
        System.out.println(factor1);
        System.out.println(factor2);
        return (factor1*factor2*(int)Math.pow(10.0,numZero));
    }

    public static boolean findbaohan(int[][] nums){
        int n =nums.length;
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0]-t2[0];
            }
        });
        for(int i =0;i<n;i++){
            int j =i+1;
            while(j<n && nums[j][0]<=nums[i][1]){
                if(nums[j][1]<=nums[i][1]){
                    return true;
                }
                j++;
            }
        }
        return false;

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

    public int petalsBreak2(int[] petals) {
        // write code here
        if(petals==null ||petals.length==0){
            return 0;
        }
        int sum=0;
        int n= petals.length;
        for (int i = 0; i <n ; i++) {
            int a =  petals[i]/2;
            int b = petals[i]%2;
            if(b>a)a++;
            sum +=a;
        }
        return  sum;
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

package com.practice;

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
public class practice2 {
    public static void main(String[] args) {
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
            map.put(times[i][0],map.getOrDefault(1,map.get(times[i][0]))+1);
            map.put(times[i][1],map.getOrDefault(-1,map.get(times[i][0]))-1);
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

package com.imooc;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author Lincoln
 * @classname main
 * @description 类的描述
 * @params TODO
 * @return
 * @date 2021/4/14 10:56
 */
// 趋势科技第二题
//public class Main {
//    public static void main(String[] args) {
//        int[] jobs = {1,2,3,3,2};
//        int k =4;
//        Main main = new Main();
//        System.out.println(main.minimumTimeRequired(jobs,k));
//        System.out.println(Arrays.toString(main.selectGroup(jobs,k)));
//    }
//
//    public int[] selectGroup(int[] jobs,int k) {
//        int max = minimumTimeRequired(jobs, k);
//        Arrays.sort(jobs);
//        System.out.println(Arrays.toString(jobs));
//        int low = 0;
//        int high = jobs.length - 1;
//        List<Integer> list = new ArrayList<>();
//        while (low <= high) {
//            if (jobs[high] == max) {
//                list.add(jobs[high]);
//                high--;
//            } else if (jobs[high] < max) {
//                int temp = jobs[high];
//                high--;
//                while (temp + jobs[high] <= max && low<=high) {
//                    temp += jobs[high];
//                    high--;
//                }
//                while (temp + jobs[low] <= max && low <=high) {
//                    temp += jobs[low];
//                    low++;
//                }
//                list.add(temp);
//            }
//        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }
//
//
//    public int minimumTimeRequired(int[] jobs, int k) {
//        Arrays.sort(jobs);
//        int low =jobs[0];
//        int high = jobs.length-1;
//        while(low<high){
//            int temp = jobs[low];
//            jobs[low] =jobs[high];
//            jobs[high] = temp;
//            low++;
//            high--;
//        }
//        int l = jobs[0];
//        int r = Arrays.stream(jobs).sum();
//        while(l<r){
//            // mid 为目标时间分配最小值
//            int mid = (l+r)>>1;
//            if(check(jobs,k,mid)){
//                r = mid;
//            }else{
//                l = mid+1;
//            }
//        }
//        return l;
//    }
//
//    public boolean check(int[] jobs,int k,int mid){
//        //k个大组
//        int[] workloads = new int[k];
//        // 先从分配第0个人
//        return bactrack(jobs,0,mid,workloads);
//    }
//
//    public boolean bactrack(int[] jobs,int i,int limmit,int[] workloads){
//        if(i>=jobs.length){
//            // 所有工作都分配完了，则返回true
//            return true;
//        }
//        int cur = jobs[i];
//        for(int j =0;j<workloads.length;j++){
//            //依次给每个工人分配第i份工作
//            if(workloads[j]+cur<=limmit){
//                workloads[j]+=cur;
//                // 然后开始求解剩下的工作的分配方案
//                if(bactrack(jobs,i+1,limmit,workloads)){
//                    return true;
//                }
//                workloads[j]-=cur;
//            }
//            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
//            // 或者当前工作恰能使该工人的工作量达到了上限 且剩下的工作没有解决方案，那么可以直接退出
//            // 这两种情况下我们无需尝试继续分配工作，从而降低时间复杂度
//            if(workloads[j]==0 || workloads[j]+cur==limmit){
//                break;
//            }
//        }
//        return false;
//
//    }
//
//}


public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.solve3();
    }

    public void solve3() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- != 0) {
            long x = in.nextLong(), a = in.nextLong(), b = in.nextLong(), n = in.nextLong();
            long i = (2*b*n+2*a*n-2*x-a)/(4*b+2*a);//求和公式的极值点横坐标,向下取整
            //收益最小也就是0了
            long ans = 0;
            ans = Math.max(ans, sum(i, x, a, b, n));
            ans = Math.max(ans, sum(i+1, x, a, b, n));//由于i是向下取整，所以还需要比较i+1的收益
            System.out.println(ans);
        }
    }

    public long sum(long y, long x, long a, long b, long n) {
        return (n-y)*(x+b*y+x+b*y-a*(n-1-y))/2;
    }
}

//public class Main {
//    static int n,m,total;
//    static List<Integer>[] link,cost;
//    static  int[] dis;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        // 总共有m*n个格子，但是从0开始，所以再减一
//        total = m*n-1;
//        int k = sc.nextInt();
//        // link 是每个点跟哪个相关联， cost记录该关联的跳跃代价
//        link = new ArrayList[n*m];
//        cost = new ArrayList[n*m];
//        // dis 代表到每个点的最小代价
//        dis = new int[n*m];
//        for (int i = 0; i < n * m; i++) {
//            // list的每个元素还是列表，因为会存在多对多的关系
//            link[i] = new ArrayList<>();
//            cost[i] = new ArrayList<>();
//            dis[i] = Integer.MAX_VALUE;
//        }
//        int x,y,u,v,w;
//        for (int i = 0; i <= k; i++) {
//            x = sc.nextInt()-1;
//            y = sc.nextInt()-1;
//            u = sc.nextInt()-1;
//            v = sc.nextInt()-1;
//            w = sc.nextInt();
//            if(x==u && y==v)continue;
//            link[x*n+y].add(u*n+v);
//            cost[x*n+y].add(w);
//        }
//        // 到达0点的代价为0
//        dis[0] = 0;
//        dfs(0);
//        System.out.println(dis[total]==Integer.MAX_VALUE?-1:dis[total]);
//
//    }
//
//
//    public static void dfs(int cur){
//        if(cur==total){
//            return;
//        }
//        // 因为题目限制了只能从[1,1]点出发，所以必须从link[0]开始往目标点走，要是没有，那么就是走不通
//        for(int i=0;i<link[cur].size();i++){
//            // 因为到达该点有多种方案，所以该点的最小代价是所有的最小的
//            // dis[]  里面的表示每个点   link[cur]  表示从cur点开始走    link[cur].get(i)  表示从cur点走到 link[cur]中的第get(i)个点 也就是目标点
//            // 所以该目标点代价要么是现有的代价，要么从cur 点走到目标点的代价加上原cur点代价，  这两种情况的最小值
//            dis[link[cur].get(i)] = Math.min(dis[link[cur].get(i)],dis[cur]+cost[cur].get(i));
//            // 走到下一个点之后再继续走
//            dfs(link[cur].get(i));
//        }
//    }
//}

// 美团第一题
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[][] nums = new int[k][5];
//        for(int i=0;i<k;i++){
//            for(int j=0;j<5;j++){
//                nums[i][j] = sc.nextInt();
//            }
//        }
//        int ans=-1;
//        int[][] steps = new int[m][n];
//        for(int i=0;i<k;i++){
//            steps[i][]
//        }
//        System.out.println(ans);
//    }
//}


//  美团第二题
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n= sc.nextInt();
//        int m= sc.nextInt();
//        int h = sc.nextInt();
//        int[]height = new int[n];
//        for(int i=0;i<n;i++){
//            height[i]= sc.nextInt();
//        }
////        int n=5;
////        int m=3;
////        int h=2;
////        int[] height = {3,2,1,1,2};
//        int ans=-1;
//        int left = 0;
//        int right =m-1;
//        boolean isTrue = true;
//        while(right<height.length){
//            for(int i=left;i<=right;i++){
//                if(height[i]>h){
//                    isTrue =false;
//                    break;
//                }
//            }
//            if(isTrue==true){
//                System.out.println(left+1);
//                break;
//            }
//            else {
//                left++;
//                right++;
//                isTrue=true;
//            }
//        }
//        System.out.println(-1);
//    }
//}

//  美团第二题
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n= sc.nextInt();
//        int m= sc.nextInt();
//        int h = sc.nextInt();
//        int height;
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            height = sc.nextInt();
//            if(height<h)queue.add(i);
//            if(queue.size()>0){
//                if(i-queue.peek()+1 ==m){
//                    if(queue.size()==m){
//                        System.out.println(queue.peek()+1);
//                        return;
//                    }else{
//                        queue.remove();
//                    }
//                }
//            }
//        }
//        System.out.println(-1);
//    }
//}


// 美团第三题
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for(int i=0;i<t;i++){
//                int curState = sc.nextInt();
//                int downa = sc.nextInt();
//                int upb = sc.nextInt();
//                int n = sc.nextInt();
//                int profit = 0;
//                System.out.println(cal(0,n,profit,curState,downa,upb));
//            }
//        new String("1")
//    }
//    public  static  int cal(int cur,int n,int profit,int curState,int downa,int upb){
//        if(cur==n){
//            return profit;
//        }
//        int res1 = cal(cur+1,n,profit+curState,curState-Math.min(curState,downa),downa,upb);
//        int res2 = cal(cur+1,n,profit,curState+upb,downa,upb);
//        return Math.max(res1,res2);
//    }
//}


//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        int[][] nums = new int[t][4];
//        for(int i=0;i<t;i++){
//            for(int j=0;j<4;j++){
//                nums[i][j] = sc.nextInt();
//            }
//        }
//        // t组
//        for (int j = 0; j < t; j++) {
//            int curState = nums[j][0];
//            int downa = nums[j][1];
//            int upb = nums[j][2];
//            int n = nums[j][3];
//            int profit = 0;
//            System.out.println(cal(0,n,profit,curState,downa,upb));
//        }
//
//    }
//    public  static  int cal(int cur,int n,int profit,int curState,int downa,int upb){
//        if(cur==n){
//            return profit;
//        }
//        int res1 = cal(cur+1,n,profit+curState,curState-Math.min(curState,downa),downa,upb);
//        int res2 = cal(cur+1,n,profit,curState+upb,downa,upb);
//        return Math.max(res1,res2);
//    }
//}








//    public static void main(String[] args) {
//        int[] nums = {4,2,0,2,3,2,0};
//        nextPermutation(nums);
//        for(int num:nums){
//            System.out.print(num +" ");
//        }
//    }
//    public static void nextPermutation(int[] nums) {
//        int len = nums.length;
//        if(len<=1){
//            return ;
//        }
//        int last = len-1;
//        int first = len-2;
//        while(last>=1){
//            while(first>=0){
//                if(nums[first]<nums[last]){
//                    System.out.println("---first="+first);
//                    System.out.println("---last="+last);
//                    int temp =nums[first];
//                    nums[first]= nums[last];
//                    nums[last] = temp;
//                    first = first+1;
//                    last = len;
//                    for(int i=first;i<last;i++){
//                        for(int j = i+1;j<last;j++){
//                            if(nums[i]>nums[j]){
//                                int tep = nums[i];
//                                nums[i] = nums[j];
//                                nums[j] = tep;
//                            }
//                        }
//                    }
//                    return;
//                }
//                first--;
//            }
//            last--;
//            first = last-1;
//        }
//        // System.out.println("-----");
//        first=0;
//        last =len-1;
//        while(first<last){
//            int temp = nums[first];
//            nums[first]=nums[last];
//            nums[last]=temp;
//            first++;
//            last--;
//        }
//        return;
//    }
//}




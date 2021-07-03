package com.practice;

/**
 * @program: HelloWorld
 * @description: 笔试算法题
 * @author: 董明林
 * @date: 2021-07-03 11:28:15
 */
public class practice3 {
    public int sum;

    public static void main(String[] args) {
        int i = new practice3().combinationSum3();
        System.out.println(i);
    }

    public int combinationSum3() {
        int x0=0,y0=0;
        int x1=8,y1=7;
        sum = 0;
        dfs(x0,y0 ,x1, y1);
        return sum;
    }

    private void dfs(int x0, int y0, int x1, int y1) {
        if(x0>x1 || y0>y1){
            return;
        }
        else if(x0==x1 && y0==y1){
            sum++;
            return;
        }
        else {
            dfs(x0+2,y0+1,x1,y1);
            dfs(x0+1,y0+2,x1,y1);
        }

    }

}


//    public List<List<Integer>> combinationSum3(int k, int n) {
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        List<Integer> list = new ArrayList<Integer>();
//        int sum = 0;
//
//        dfs(1, k, n, lists, list, sum);
//        return lists;
//    }
//
//    private void dfs(int index, int k, int n, List<List<Integer>> lists, List<Integer> list, int sum) {
//        if(sum >= n || index >= n || list.size() >= k){	//终止条件
//            if(sum == n && list.size() == k){
//                lists.add(new ArrayList<>(list));
//            }
//            return;
//        }
//        else {
//            for(int i=index; i<n; i++){
//                list.add(i);
//                sum += i;
//                dfs(++index, k, n, lists, list, sum);
//                sum -= list.get(list.size()-1);
//                list.remove(list.size()-1);
//            }
//        }
//
//    }
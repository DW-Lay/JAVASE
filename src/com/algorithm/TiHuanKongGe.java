package com.algorithm;

/**
 * @program: HelloWorld
 * @description: 常考算法题  替换空格
 * @author: 董明林
 * @date: 2021-07-14 19:57:46
 */
public class TiHuanKongGe {
    public static void main(String[] args) {
        String test = "2 as  s dsn fro";
        System.out.println(new TiHuanKongGe().replaceSpace(test));
    }
    public String replaceSpace(String str) {
        StringBuffer out=new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char b=str.charAt(i);
            if(String.valueOf(b).equals(" ")){
                out.append("%20");
            }else{
                out.append(b);
            }
        }
        return out.toString();
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode pre=null,cur = head;
        while(cur!=null){
            ListNode after = cur.next;
            cur.next =pre;
            pre = cur;
            cur = after;
        }
        return pre;

    }


}
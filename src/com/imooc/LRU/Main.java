package com.imooc.LRU;

import java.util.HashMap;

/**
 * @program: HelloWorld
 * @description: 手写实现LRU
 * @author: 董明林
 * @date: 2021-07-11 20:39:11
 */
public class Main {

    public static void main(String[] args) {

        LRUCahche cache = new LRUCahche(5);
        cache.put("1","11");
        cache.put("2","22");
        cache.put("3","33");
        cache.put("4","44");
        cache.put("5","55");
        cache.cache.displayNext();
        System.out.println("=============");
        cache.put("3","32");
        cache.cache.displayNext();
        System.out.println("=============");
        cache.put("6","66");
        cache.cache.displayNext();
        System.out.println("=============");
        cache.get("2");
        cache.cache.displayNext();



    }

    // 因为lru算法实现逻辑中需要实现双向链表，但是双向链表需要自己实现，在此只先写出双向链表的类，具体实现额外再写
    static class Node{
        public String key,val;
        public Node next,prev;
        public Node(String x,String y){
            this.key =x;
            this.val = y;
        }
    }

    static class DoubleList{
        private Node head;

        // 增加头结点
        public void addFirst(Node x) {
            if(head==null){
                head = x;
            }else{
                x.next =head;
                head.prev = x;
                head=x;
            }
        }

        public void displayNext(){
            // 将表头作为当前节点
            Node currentNode = head;
            // 遍历链表
            while (currentNode!=null){
                // 打印数据
                System.out.println(currentNode.val);
                // 将下一个节点作为当前节点
                currentNode = currentNode.next;
            }
        }
        //插入尾结点
        public void addLast(Node x){

            // 如果表头为空直接将新节点作为头
            if (head==null){
                head = x;
            }else {
                Node currentNode = head;
                //寻找尾节点
                while (currentNode.next!=null){
                    currentNode = currentNode.next;
                }
                //表尾的后续节点指向新节点
                currentNode.next=x;
                //新节点的前驱节点指向表尾
                x.prev= currentNode;
            }
        }


        // 删除任意结点
        public void remove(Node x){
            //   x 为头结点的情况
                if(head == x){
                    head = head.next;
                }else if(x.next == null){    // x为尾结点的情况
                    removeLast();
                }else {
                    x.prev.next = x.next;
                    x.next.prev = x.prev;
                }
        }


        // 删除尾结点
        public Node removeLast(){

            if (size()==0){
                return null;
            }
            // 只有一个节点直接清空表头
            if (size()==1){
                head=null;
                return head;
            }
            Node previousNode = head;
            // 寻找尾节点的前驱节点
            while (previousNode.next.next!=null){
                previousNode = previousNode.next;
            }
            Node res= previousNode.next;
            previousNode.next = null;
            return res;

        }

        // 得到链表 长度
        public int size(){
            int length = 0;
            // 当前节点
            Node currentNode = head;
            while (currentNode!=null){
                // 一个节点 length 长度就加1
                length++;
                // 将下一个节点作为当前节点
                currentNode = currentNode.next;
            }
            return length;
        }

    }
    static class LRUCahche{
        private HashMap<String,Node> map;
        private DoubleList cache;
        private int cap;
        public LRUCahche(int capacity){
            map = new HashMap<>();
            cache = new DoubleList();
            this.cap = capacity;
        }

        public String get(String key){
            // 查找，如果不存在，直接返回-1
            if(!map.containsKey(key)){
                return "null";
            }
            // 如果存在，利用put方法把数据提前
            String  val = map.get(key).val;
            put(key,val);
            return val;
        }

        public void put(String key,String  val){
            // 现根据输入的key和val，得到一个Node
            Node x =new Node(key,val);
            if(map.containsKey(key)){
                // 如果存在，删除旧节点，新的插入到头部
                cache.remove(map.get(key));
                cache.addFirst(x);
                // 更新map中对应的数据
                map.put(key,x);
            }else{
                if(cap==cache.size()){
                    // 删除链表的最后一个数据
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                // 直接插入到头部
                cache.addFirst(x);
                map.put(key,x);
            }
        }
    }



}
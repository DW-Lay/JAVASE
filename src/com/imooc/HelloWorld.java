package com.imooc;
//import com.sun.org.apache.xpath.internal.objects.XString;
//import com.sun.org.apache.xpath.internal.objects.XStringForChars;

import sun.net.util.IPAddressUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class HelloWorld {
/***
 *          .,:,,,                                        .::,,,::.
 *        .::::,,;;,                                  .,;;:,,....:i:
 *        :i,.::::,;i:.      ....,,:::::::::,....   .;i:,.  ......;i.
 *        :;..:::;::::i;,,:::;:,,,,,,,,,,..,.,,:::iri:. .,:irsr:,.;i.
 *        ;;..,::::;;;;ri,,,.                    ..,,:;s1s1ssrr;,.;r,
 *        :;. ,::;ii;:,     . ...................     .;iirri;;;,,;i,
 *        ,i. .;ri:.   ... ............................  .,,:;:,,,;i:
 *        :s,.;r:... ....................................... .::;::s;
 *        ,1r::. .............,,,.,,:,,........................,;iir;
 *        ,s;...........     ..::.,;:,,.          ...............,;1s
 *       :i,..,.              .,:,,::,.          .......... .......;1,
 *      ir,....:rrssr;:,       ,,.,::.     .r5S9989398G95hr;. ....,.:s,
 *     ;r,..,s9855513XHAG3i   .,,,,,,,.  ,S931,.,,.;s;s&BHHA8s.,..,..:r:
 *    :r;..rGGh,  :SAG;;G@BS:.,,,,,,,,,.r83:      hHH1sXMBHHHM3..,,,,.ir.
 *   ,si,.1GS,   sBMAAX&MBMB5,,,,,,:,,.:&8       3@HXHBMBHBBH#X,.,,,,,,rr
 *   ;1:,,SH:   .A@&&B#&8H#BS,,,,,,,,,.,5XS,     3@MHABM&59M#As..,,,,:,is,
 *  .rr,,,;9&1   hBHHBB&8AMGr,,,,,,,,,,,:h&&9s;   r9&BMHBHMB9:  . .,,,,;ri.
 *  :1:....:5&XSi;r8BMBHHA9r:,......,,,,:ii19GG88899XHHH&GSr.      ...,:rs.
 *  ;s.     .:sS8G8GG889hi.        ....,,:;:,.:irssrriii:,.        ...,,i1,
 *  ;1,         ..,....,,isssi;,        .,,.                      ....,.i1,
 *  ;h:               i9HHBMBBHAX9:         .                     ...,,,rs,
 *  ,1i..            :A#MBBBBMHB##s                             ....,,,;si.
 *  .r1,..        ,..;3BMBBBHBB#Bh.     ..                    ....,,,,,i1;
 *   :h;..       .,..;,1XBMMMMBXs,.,, .. :: ,.               ....,,,,,,ss.
 *    ih: ..    .;;;, ;;:s58A3i,..    ,. ,.:,,.             ...,,,,,:,s1,
 *    .s1,....   .,;sh,  ,iSAXs;.    ,.  ,,.i85            ...,,,,,,:i1;
 *     .rh: ...     rXG9XBBM#M#MHAX3hss13&&HHXr         .....,,,,,,,ih;
 *      .s5: .....    i598X&&A&AAAAAA&XG851r:       ........,,,,:,,sh;
 *      . ihr, ...  .         ..                    ........,,,,,;11:.
 *         ,s1i. ...  ..,,,..,,,.,,.,,.,..       ........,,.,,.;s5i.
 *          .:s1r,......................       ..............;shs,
 *          . .:shr:.  ....                 ..............,ishs.
 *              .,issr;,... ...........................,is1s;.
 *                 .,is1si;:,....................,:;ir1sr;,
 *                    ..:isssssrrii;::::::;;iirsssssr;:..
 *                         .,::iiirsssssssssrri;;:.
 */

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println("hello,鲸灵".getBytes("UTF-8").length);
        System.out.println("hello,鲸灵".getBytes("unicode").length);

    }
}
// 因为lru算法实现逻辑中需要实现双向链表，但是双向链表需要自己实现，在此只先写出双向链表的类，具体实现额外再写
class Node{
    public int key,val;
    public  Node next,prev;
    public Node(int x,int y){
        this.key =x;
        this.val = y;
    }
}
class DoubleList{
    public void addFirst(Node x) {

    }
     public void remove(Node x){

     }

     public Node removeLast(){

        return new Node(0,0);
     }
     public int size(){
        return 0;
     }

}
class LRUCahche{
    private HashMap<Integer,Node> map;
    private DoubleList cache;
    private int cap;
    public LRUCahche(int capacity){
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = capacity;
    }

    public int get(int key){
        // 查找，如果不存在，直接返回-1
        if(!map.containsKey(key)){
            return -1;
        }
        // 如果存在，利用put方法把数据提前
        int val = map.get(key).val;
        put(key,val);
        return val;
    }

    public void put(int key,int val){
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

//        float d1 = 123456789f;
//        float d2 = d1 + 1;
//        System.out.println("d1=" + d1);
//        System.out.println("d2=" + d2);
//        System.out.println(d1 == d2);
//        char c = 'a';
//        System.out.println("c=" + c);
//        System.out.println('\u0061');
//        int a = 3;
//        a=a++;
//        int b=a++;
//
//        System.out.println("========== "+a);
//        System.out.println("========== "+b);
//        Integer abc;
//        abc = new Integer(3);
//        abc.toString();

//        Scanner input = new Scanner(System.in);
//
//        System.out.print("请输入考试成绩：");
//        int score = input.nextInt();
//        int count =0;
//        System.out.println("修改之前的成绩为"+score);
//        while (score<60){
//            score++;
//            count++;
//        }
//        //test
//        System.out.println("修改之后的成绩为"+score);
//        System.out.println("共加了"+count+"次");
////        System.out.println("welcome to idea java!");
//        String str = "12";
//        String strTemp = str.substring(0,str.length()-2);
//        if( strTemp.equals("")) {
//            System.out.println("为null");
//        }else {
//            System.out.println(strTemp);
//        }

//    }


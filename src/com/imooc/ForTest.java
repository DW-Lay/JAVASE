package com.imooc;

/**
 * @author Lincoln
 * @classname ForTest
 * @description 类的描述
 * @params TODO
 * @return
 * @date 2020/6/25 1:03
 */
public class ForTest {
    public static void main(String[] args) {
        String code0 = "01";
        String code1= "0102";
        String code2 = "010203";
        String newCode= "";
        int length = code2.length()/2;
        System.out.println("length= "+length);
        String[] codeElements = new String[length];
        String[] newCodeElements = new String[length];
        for (int i = 0; i <length ; i++) {
            codeElements[i] = code2.substring(i*2,i*2+2);
            newCodeElements[i] = "0"+codeElements[i];
        }
        for (int i = 0; i < length; i++) {
            newCode+=newCodeElements[i];
        }
        System.out.println("code= "+code2);
        System.out.println("newCode= "+newCode);

    }
}

package QuNaEr.ChunZhao2017.JinzhiZhuanhuan;

import java.util.Scanner;

/**
 * Created by tzy on 2017/4/1.
 * 用英文字母a-z来分别表示数值0-25, 形成一个26进制的数值表示法。需要你写一个方法，将用a-z表示的26进制数值的字符串，转化为对应的10进制数值。
 * 注意要换成long型
 * 霍纳算法~~~~~~~~~~
 */
public class Main {
    public static long hexToDecimal(String hex){
        long decimalValue=0;
        for (int i=0;i<hex.length();i++){
            char hexChar=hex.charAt(i);
            decimalValue=decimalValue*26+hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    public static int hexCharToDecimal(char ch){
        if (ch>='a'&&ch<='z');
        return ch-97;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            System.out.println(hexToDecimal(string));
        }
    }
}

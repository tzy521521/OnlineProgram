package QuNaEr.ChunZhao2017.JinzhiZhuanhuan;

import java.util.Scanner;

/**
 * Created by tzy on 2017/4/1.
 * 用英文字母a-z来分别表示数值0-25, 形成一个26进制的数值表示法。需要你写一个方法，将用a-z表示的26进制数值的字符串，转化为对应的10进制数值。
 * 注意要换成long型
 *分析霍纳算法~~~~~~~~~~bdc转换成十进制
 */
public class Main {
    //判断输入的字符串是不是全是小写字符
    public static boolean isLowString(String string){
        for (int i = 0; i <string.length() ; i++) {
            if (!(string.charAt(i)>='a'&&string.charAt(i)<='z'))
                return false;
        }
        return true;
    }
    //26进制转换成10进制。
    public static long hexToDecimal(String hex){
        long decimalValue=0;
        for (int i=0;i<hex.length();i++){
            decimalValue=decimalValue*26+(hex.charAt(i)-97);
        }
        return decimalValue;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            //输入的字符串必须全是小写字符才有效。
            if (isLowString(string))
                System.out.println(hexToDecimal(string));
        }
    }
}

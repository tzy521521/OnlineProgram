package HuaWei.Solution;

import java.util.Scanner;

/**
 * Created by tzy on 2017/8/30.
 * 在某种场景下，开发人员决定使用字母来表示一个正整数，该方法利用英文的小写字母表示，
 * 映射规则很简单，按字母顺序每一个字母都代表一个值。如下所示列表中的部分内容。字母表示 对应十进制
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
        return ch-96;
    }
    public static boolean isLowString(String string){
        for (int i = 0; i <string.length() ; i++) {
            if (!(string.charAt(i)>='a'&&string.charAt(i)<='z'))
                return false;
        }
        return true;
    }
    public static boolean isNum(String string){
        for (int i = 0; i <string.length() ; i++) {
            if (!(string.charAt(i)>='0'&&string.charAt(i)<='9'))
                return false;
        }
        return true;
    }
    public static String numToString(String string){
        int num=Integer.valueOf(string);
        String stri="";
        while (num!=0){
            int yu=num%26;
            stri=numToChar(yu)+stri;
            num=num/26;
        }
        return stri;
    }
    public static char numToChar(int num){
        return (char) (num+96);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            if (isLowString(string)){
                System.out.println(hexToDecimal(string));
            }else if (isNum(string)){
                System.out.println(numToString(string));
            }
            else
                System.out.println("ERROR");
        }
    }
}

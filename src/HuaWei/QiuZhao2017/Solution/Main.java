package HuaWei.QiuZhao2017.Solution;

import java.util.Scanner;

/**
 * Created by tzy on 2017/8/30.
 * 在某种场景下，开发人员决定使用字母来表示一个正整数，该方法利用英文的小写字母表示，映射规则很简单，
 * 按字母顺序每一个字母都代表一个值。
 */
public class Main {
    //26进制转换成10进制。
    public static long hexToDecimal(String hex){
        long decimalValue=0;
        for (int i=0;i<hex.length();i++){
            decimalValue=decimalValue*26+(hex.charAt(i)-96);
        }
        return decimalValue;
    }
    //判断是否是有效的小写字符串
    public static boolean isLowString(String string){
        for (int i = 0; i <string.length() ; i++) {
            if (!(string.charAt(i)>='a'&&string.charAt(i)<='z'))
                return false;
        }
        return true;
    }
    //判断是否是有效的数字字符串
    public static boolean isNum(String string){
        /*
        try {
            //注意 "+153658"是符合要求的，本题的不知道测试用例有没有这个。
            Long.valueOf(string);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
         */
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
            stri=(char)(yu+96)+stri;
            num=num/26;
        }
        return stri;
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

package HuaWei.Solution2;

import java.util.Scanner;

/**
 * Created by tzy on 2017/8/30.
 */
public class Main {
    public static void main(String[] args) {
        String string="int add(int x,int y){\n" +
                "        int sum=0;\n" +
                "        sum=x+y;\n" +
                "        return sum;\n" +
                "    }";
        System.out.println(isSame(string));

    }
    public static int isSame(String string){
        string=string.replaceAll("int","");
        string=string.replaceAll("\\s+","");
        String match="[a-zA-z]+\\([a-zA-z]+,[a-zA-z]+\\)\\{[a-zA-z]+=0;[a-zA-z]+=[a-zA-z]+\\+[a-zA-z]+;return[a-zA-z]+;}";

        if (string.matches(match)){
            String text1=string.substring(string.indexOf("(")+1,string.indexOf(","));
            String text2=string.substring(string.indexOf(",")+1,string.indexOf(")"));
            String text3=string.substring(string.indexOf("{")+1,string.indexOf("="));
            String text4=string.substring(string.indexOf(";")+1,string.lastIndexOf("="));
            String text5=string.substring(string.lastIndexOf("=")+1,string.lastIndexOf("+"));
            String text6=string.substring(string.indexOf("+")+1,string.lastIndexOf("return")-1);
            String text7=string.substring(string.indexOf("return")+6,string.lastIndexOf(";"));
            if (text3.equals(text4)&&text3.equals(text4)&&!text1.equals(text2)&&(text1.equals(text5)&&text2.equals(text6)||text2.equals(text5)&&text1.equals(text6)))
                return 1;
        }
        return 0;
    }
    public int add(int x,int y){
        int sum=0;
        sum=x+y;
        return sum;
    }
}

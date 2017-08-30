package HuaWei.Solution2;

import java.util.Scanner;

/**
 * Created by tzy on 2017/8/30.
 * 输入的是有效的程序段？
 */
public class Main {
    public static void main(String[] args) {
        /*
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            System.out.println(isSame(string));
        }
         */
        String strin="int add(int x,int y){\n" +
                "        int sum=0;\n" +
                "        sum=x+y;\n" +
                "        return sum;\n" +
                "    }";
        System.out.println(isSame(strin));
    }
    public static int isSame(String string){
        string=string.replaceAll("\\s+","");
        String match="int[a-zA-z]+\\(int[a-zA-z]+,int[a-zA-z]+\\)\\{int[a-zA-z]+=0;[a-zA-z]+=[a-zA-z]+\\+[a-zA-z]+;return[a-zA-z]+;}";
        if (string.matches(match)){
            String text1=string.substring(string.indexOf("(int")+4,string.indexOf(",int"));
            String text2=string.substring(string.indexOf(",int")+4,string.indexOf(")"));
            String text3=string.substring(string.indexOf("{int")+4,string.indexOf("="));
            String text4=string.substring(string.indexOf(";")+1,string.lastIndexOf("="));
            String text5=string.substring(string.lastIndexOf("=")+1,string.lastIndexOf("+"));
            String text6=string.substring(string.indexOf("+")+1,string.lastIndexOf(";return"));
            String text7=string.substring(string.indexOf("return")+6,string.lastIndexOf(";"));
            if (text3.equals(text4)&&text3.equals(text7)&&!text1.equals(text2)&&(text1.equals(text5)&&text2.equals(text6)||text2.equals(text5)&&text1.equals(text6)))
                return 1;
        }
        return 0;
    }
}

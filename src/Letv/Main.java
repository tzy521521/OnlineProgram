package Letv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/6.
 * 数字游戏
     真是一个无聊的夜晚啊，小B和小C在宿舍中实在无聊之极，因此决定玩一个数字游戏打发时间。小B首先开始，她给小C的问题是：
 给定任意一个整数，小C可以交换该数中任意的不同位，能够得到的最小数值是多少？前提是不能有前导0。
 小C很快就给出了一个答案，小B希望你来帮她检验答案的正确性，你能帮忙吗？
     输入
 输入中有多组测试数据。每组测试数据的第一行为一个没有前导0的整数n（0=＜n =＜10^9），第二行为另一个整数m（0=＜m=＜10^9），
 小C给出的问题答案。
     输出
 对每组测试数据，在单独的行中输出结果，若小C的答案是正确的，输出YES，否则输出NO。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.next();
            String result=scanner.next();
            String min=minInteger(string);
            if (min.equals(result))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static String minInteger(String string){
        char[] chars=string.toCharArray();
        Arrays.sort(chars);
        int index=0;
        while (index<chars.length){
            if (chars[index]!='0')
                break;
            index++;
        }
        if (index<chars.length){
            char c=chars[index];
            chars[index]=chars[0];
            chars[0]=c;
        }
        return new String(chars);
    }
}

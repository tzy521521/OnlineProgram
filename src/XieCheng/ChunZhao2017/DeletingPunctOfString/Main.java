package XieCheng.ChunZhao2017.DeletingPunctOfString;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //加上while (scanner.hasNext())只能通过83%。
        //while (scanner.hasNext()){
            System.out.println("Enter a string:");
            //只能用nextLine()
            String string=scanner.nextLine().replaceAll("\\s+","");
            string=string.replaceAll("\\p{Punct}",",");
            if (string.contains(",")){
                string=string.replaceAll(",","");
                System.out.println("Result:");
                System.out.println(string);
            }else {
                //不包含标点符号时，此语句必须输出(赛马网上的输入输出表述有误)。
                System.out.println("No punctuation character in the string?! ");
            }
        //}
    }
}

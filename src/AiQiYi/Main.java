package AiQiYi;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] strings=scanner.nextLine().split("\\s+");
            System.out.println(comparRepeat(strings));
        }
    }
    public static String comparRepeat(String [] strings){
        String x1=strings[0];int k1=Integer.valueOf(strings[1]);
        String x2=strings[2];int k2=Integer.valueOf(strings[3]);
        String s1=repeat(x1,k1);
        String s2=repeat(x2,k2);
        BigInteger b1=new BigInteger(s1);
        BigInteger b2=new BigInteger(s2);
        if (b1.compareTo(b2)>0)
            return "Greater";
        else if (b1.compareTo(b2)<0)
            return "Less";
        else
            return "Equal";
    }
    public static String repeat(String x,int k){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <k ; i++) {
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }
}

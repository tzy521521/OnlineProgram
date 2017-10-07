package iQIYI.QiuZhao2017.CycleNumberComparison;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/10.
 * 循环数比较：
 * 对于任意正整数x和k，我们定义repeat(x,k)为将重复写k次形成的数。如repeat(12,4)=12121212，
 * 现在牛牛给出4个整数x1,k1,x2,k2,其中v1=repeat(x1,k1);v2=repeat(x2,k2),比较v1和v2的大小。
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

        String v1=repeat(x1,k1);
        String v2=repeat(x2,k2);
        /*直接字符串比较也是可以的。
        if (v1.compareTo(v2)>0)
            return "Greater";
        else if (v1.compareTo(v2)<0)
            return "Less";
        else
            return "Equal";
         */
        BigInteger b1=new BigInteger(v1);
        BigInteger b2=new BigInteger(v2);
        if (b1.compareTo(b2)>0)
            return "Greater";
        else if (b1.compareTo(b2)<0)
            return "Less";
        else
            return "Equal";
    }
    private static String repeat(String x,int k){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <k ; i++) {
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }
}

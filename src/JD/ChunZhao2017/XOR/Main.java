package JD.ChunZhao2017.XOR;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by tzy on 2017/8/31.
 * 输入有三行，第一行一个数n(1<=n<=20)，接下来两行有两个n位二进制数。输入的二进制数可能有前导零。
 * 输出一个数，异或结果的十进制数值，不要输出前导零。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            String string0=scanner.next();
            String string1=scanner.next();
            //BigInteger(String val, int radix)将指定基数的 BigInteger 的字符串表示形式转换为 BigInteger。(2到36禁止)
            BigInteger bigInteger1=new BigInteger(string0,2);
            BigInteger bigInteger2=new BigInteger(string1,2);
            System.out.println(bigInteger1.xor(bigInteger2));
        }
    }
}

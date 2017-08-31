package WangYi.Qiuzhao2017.Independent;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by tzy on 2017/8/31.
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。
 * 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int x0=scanner.nextInt();
            int f0=scanner.nextInt();
            int d0=scanner.nextInt();
            int p0=scanner.nextInt();
            BigInteger x=new BigInteger(x0+"");
            BigInteger f=new BigInteger(f0+"");
            BigInteger d=new BigInteger(d0+"");
            BigInteger p=new BigInteger(p0+"");
            if (d0/x0<=f0)
                System.out.println(d0/x0);
            else{
                BigInteger temp=d.add(f.multiply(p));
                BigInteger temp1=p.add(x);
                System.out.println(temp.divide(temp1));
            }
        }
    }
}

package iQIYI.QiuZhao2017_2.Boring;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by tzy on 2017/10/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            System.out.println(getExp(n,m));
        }
    }
    public static BigDecimal getExp(int n,int m){
        BigInteger total=combination(m+n,2);
        BigInteger num=combination(m,2);
        int temp=n*m;
        BigInteger num1=new BigInteger(String.valueOf(temp));
        BigInteger sum=num.add(num1);
        BigDecimal total0=new BigDecimal(total);
        BigDecimal sum0=new BigDecimal(sum);
        return total0.divide(sum0,1,BigDecimal.ROUND_UP);
    }

    public static BigInteger combination(int n, int m) {
        BigInteger big_m=factorial(m);
        BigInteger big_n=factorial(n);
        BigInteger big_n_m=factorial(n-m);

        BigInteger result=big_n.divide(big_n_m);
        result=result.divide(big_m);
        return (n >= m) ? result : new BigInteger("0");
    }
    private static BigInteger factorial(int n) {
        BigInteger result=new BigInteger("1");
        for (int i = 1; i <=n ; i++) {
            result=result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
}

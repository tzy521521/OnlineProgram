package DiDi.Soution;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/23.
 * 快速幂~~~~~~~~~~~~~~~~~~~~~~复杂度为O(log₂N)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            double R=scanner.nextDouble();
            int N=scanner.nextInt();
            System.out.println(power(R,N));
        }
    }
    private static BigDecimal power(double base, int exponent) {
        BigDecimal bigDecimab=BigDecimal.valueOf(base);
        BigDecimal rslt=new BigDecimal(1);
        int n=Math.abs(exponent);
        while (n!=0) {
            //如果exponent为奇数
            if ((n&1)==1)
                rslt=rslt.multiply(bigDecimab);
            bigDecimab=bigDecimab.multiply(bigDecimab);
            n>>=1;
        }
        if (exponent == 0)
            return new BigDecimal(1);
        else if (exponent>0)
            return rslt;
        else
            return new BigDecimal(1).divide(rslt);
    }
}

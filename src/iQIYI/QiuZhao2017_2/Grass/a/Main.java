package iQIYI.QiuZhao2017_2.Grass.a;

import java.text.DecimalFormat;
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
            double result=getExp(n,m);
            DecimalFormat df=new DecimalFormat("#.0");
            System.out.println(df.format(result));
        }
    }
    public static double getExp(int n,int m){
        long total=combination(m+n,2);
        long num=combination(m,2);
        long num1=m*n;
        return (double)total/(num+num1);
    }
    public static long combination(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }
    private static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }
}

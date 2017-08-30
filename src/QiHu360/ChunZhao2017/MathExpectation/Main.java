package QiHu360.ChunZhao2017.MathExpectation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Created by tzy on 2017/3/25.
 * 期望
 * 小明同学最近学习了概率论，他了解到数学期望的定义：
 * 设X为一个随机变量，X可以取n种不同的取值x1,x2,x3,…,xn。取x1的概率为p1,取x2的概率为p2,以此类推。
 * 定义随机变量X的数学期望为：E[X]=x1*p1+x2*p2+…+xn*pn。
 *
 * 输入：输入第一行一个数n(1<=n<=100)，接下来有n行，第i行有两个数xi和pi，xi和pi都是整数，-100<=xi<=100, 0<=pi<=100。
 * 表示随机变量X取值为xi的概率是pi/100。输入保证p1+p2+p3+…+pn=100。
 * 输出：输出一个数，随机变量X的数学期望E[x]，小数点后四舍五入保留3位。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int xi[]=new int[n];
            double pi[]=new double[n];
            for (int i=0;i<n;i++){
                xi[i]=sc.nextInt();
                pi[i]=sc.nextDouble();
            }
            double temp=Excpet(xi,pi);
            BigDecimal bigDecimal=new BigDecimal(""+temp);
            System.out.println(bigDecimal.setScale(3, RoundingMode.HALF_EVEN));
        }
    }
    public static double Excpet(int[] xi,double[] pi){
        double exp=0;
        for (int j=0;j<xi.length;j++){
            exp+=xi[j]*(pi[j]/100);
        }
        return exp;
    }
}

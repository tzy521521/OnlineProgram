package JD.ChunZhao2017.LuckyNumber.Solution0;

import java.util.Scanner;

/**
 * Created by tzy on 2017/8/31.
 * 时间超时。算法复杂度高？增加位运算没有效果。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            for (int i = 0; i <n ; i++) {
                System.out.println(luckyNumber(scanner.nextInt()));
            }
        }
    }
    public static int luckyNumber(int n){
        int nums=0;
        for (int m = 1; m <= n; m++) {
            if (f(m)==g(m))
                nums++;
        }
        return nums;
    }
    /*
    public static int sumSystem(int m,int jz){
        int sum=0;
        while (m!=0){
            sum+=m%jz;
            m=m/jz;
        }
        return sum;
    }
     */
    public static int f(int m){
        int sum=0;
        while (m!=0){
            sum+=m%10;
            m=m/10;
        }
        return sum;
    }
    public static int g(int m){
        int sum=0;
        while (m!=0){
            //sum+=m%2;
            sum+=m&1;
            //m=m/2;
            m>>=1;
        }
        return sum;
    }
}

package iQIYI.QiuZhao2017.SquareRoot;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/10.
 * 于是原问题就是看a*b是否能是完全平方数,详细做法见代码注释。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            System.out.println(solve(n,m));
        }
    }
    private static int solve(int n,int m){
        int sum=0;
        for (int i = 1; i <=n ; i++) {
            int s=1;
            for (int j = 2; j <i/j ; j++) {
                if (i%(j*j)==0){
                    s=j*j;
                }
            }
            int r=i/s;
            for (int k = 1; k*k*r <=m ; k++) {
                sum++;
            }
        }
        return sum;
    }
}

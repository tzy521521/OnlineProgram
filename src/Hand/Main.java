package Hand;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/12.
 * 第1项的值为1，Fn=Fn-1+Fn-2,给出第N项目的值，判断第二项是否为整数，如果是输出这个整数。
 * 设第2项为X,推出各项，会发现X前的系数是fibonacci1数，X后加的数是一个fibonacci1。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            System.out.println(getNums2(n,k));
        }
    }
    public static int getNums2(int n,int k){
        int xishu=fibonacci1(n-1);
        int canshu=fibonacci1(n-2);
        if ((k-canshu)%xishu==0)
            return  (k-canshu)/xishu;
        return -1;
    }
    public static int fibonacci1(int n){
        if (n<0)
            return 0;
        int f0=0;
        int f1=1;
        int f2=1;
        if (n==0)
            return f0;
        else if (n==1)
            return f1;
        else if (n==2)
            return f2;
        for (int i=3;i<=n;i++){
            f0=f1;
            f1=f2;
            f2=f0+f1;
        }
        return f2;
    }
}

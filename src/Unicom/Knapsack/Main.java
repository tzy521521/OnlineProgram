package Unicom.Knapsack;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/27.
 * 背包问题：多重背包-二进制优化。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();//物品的数量。
            int w=scanner.nextInt();//背包的容量。

            int[] count =new int[n];//物品的数量。
            int[] weight=new int[n];//物品的体积或者重量。
            int[] value =new int[n];//物品的价值。
            for (int i = 0; i <n ; i++) {
                count[i] =scanner.nextInt();
                weight[i]=scanner.nextInt();
                value[i] =scanner.nextInt();
            }
            dp=new int[w+1];
            //
            for (int i = 1; i <n+1 ; i++) {
                if (count[i-1]*weight[i-1]>=w){
                    compeltePack(weight[i-1],value[i-1],w,i);
                }else {
                    int m=count[i-1];
                    for (int j = 1; j <=m ; j++) {
                        zeroOnePack(j*weight[i-1],j*value[i-1],w,i);
                        m-=j;
                        j*=2;
                    }
                    zeroOnePack(weight[i-1]*m,value[i-1]*m,w,i);
                }
            }
            System.out.println(dp[w]);
        }
    }
    private static int[] dp;
    private static void zeroOnePack(int nWeight,int nValue,int w,int i){
        for (int j = w; j >=nWeight ; j--) {
            dp[j]=Math.max(dp[j-nWeight]+nValue,dp[j]);
        }
    }
    private static void compeltePack(int nWeight,int nValue,int w,int i){
        for (int j = nWeight; j <=w ; j++) {
            dp[j]=Math.max(dp[j-nWeight]+nValue,dp[j]);
        }
    }
}

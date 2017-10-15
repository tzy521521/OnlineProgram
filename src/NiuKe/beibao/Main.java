package NiuKe.beibao;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/15.
 * 01背包问题(4种算法)
 * 有n件物品和一个容量为w的背包。第i件物品的体积是weight[i]，价值是value[i]。求装入背包物品价值最大是多少。
 解题思路：(此问题没有要求恰好把背包装满)
     用子问题定义状态：即f[i][w]表示前i件物品恰放入一个容量为w的背包可以获得的最大价值。则其状态转移方程便是：
 f[i][w]=max{f[i-1][w],f[i-1][w-weight[i-1]]+value[i-1]}
 算法复杂度:时间和空间复杂度均为O(n*w)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();//多少种物品
            int w=scanner.nextInt();//背包的容量。
            int[] weight=new int[n];//物品的体积或者重量。
            int[] value =new int[n];//物品的价值。
            for (int i = 0; i <n ; i++) {
                weight[i]=scanner.nextInt();
            }
            for (int i = 0; i <n ; i++) {
                value[i] =scanner.nextInt();
            }
            System.out.println(zeroOnePack(n,w,weight,value));
        }
    }
    private static int zeroOnePack(int n,int w, int[] weight,int[] value){
        int[][] f=new int[n+1][w+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=w ; j++) {
                //当背包容量为j时，如果第i件的重量(weight[i-1])小于重量j时，f[i][j]为下列两种情况之一：
                if (weight[i-1]<=j){
                    f[i][j]=Math.max(f[i-1][j],f[i-1][j-weight[i-1]]+value[i-1]);
                }else {
                    //如果第i件的重量(weight[i-1])大于重量j时，第i件物品肯定不装进去。
                    f[i][j]=f[i-1][j];
                }

            }
        }
        return f[n][w];
    }
    private static int zeroOnePack0(int n,int w, int[] weight,int[] value){

        return 0;
    }
}

package NiuKe.beibao1.case0;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/16.
 * 完全背包问题
 * 有n件物品和一个容量为w的背包。第i件物品的体积是weight[i]，价值是value[i],每件物品有无限个。求装入背包物品价值最大是多少。
 解题思路：(此问题没有要求恰好把背包装满)
     与01背包不同的是，完全背包每件物体可以放入无限件（只要能放的下），故对于每件物品i，相当于拆分成了w/weight[i]件相同的物品，
 拆分之后物品i就不是放入或不放入的两种情况了，而是放入0件、放入1件、放入2件…等情况了，对于该件物品i，最大价值取放入k件的最大值，
 故状态转移方程为：
 f[i][w]=max{f[i-1][w-k*weight[i-1]]+k*value[i-1]|0<=k<=w/weight[i]},k为0表示第i件物品一件也不加入背包。
 算法复杂度:空间复杂度均为O(n*w)
            时间复杂度大于为O(n*w)
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
            System.out.println(compeltePack(n,w,weight,value));
            System.out.println(compeltePack0(n,w,weight,value));
            System.out.println(compeltePack1(n,w,weight,value));
            System.out.println(compeltePack2(n,w,weight,value));
        }
    }
    //完全背包问题的基本实现
    private static int compeltePack(int n,int w, int[] weight,int[] value){
        int[][] f=new int[n+1][w+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=w ; j++) {
                int max_temp=0;
                for (int k = 0; k <=j/weight[i-1] ; k++) {
                    if (f[i-1][j-k*weight[i-1]]+k*value[i-1]>max_temp)
                        max_temp=f[i-1][j-k*weight[i-1]]+k*value[i-1];
                }
                f[i][j]=max_temp;
                /*
                if (j/weight[i-1]>=1){
                    int max_temp=0;
                    for (int k = 1; k <=j/weight[i-1] ; k++) {
                        if (f[i-1][j-k*weight[i-1]]+k*value[i-1]>max_temp)
                            max_temp=f[i-1][j-k*weight[i-1]]+k*value[i-1];
                    }
                    f[i][j]=Math.max(f[i-1][j],max_temp);
                }else
                    f[i][j]=f[i-1][j];
                 */
            }
        }
        return f[n][w];
    }
    /*
    完全背包的二进制优化?有问题
    这里的拆分是利用了一种二进制思想：即任何数字都可以表示成若干个2^k数字的和
     */
    private static int compeltePack0(int n,int w, int[] weight,int[] value){
        int[][] f=new int[n+1][w+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=w ; j++) {
                if (j/weight[i-1]>=1){
                    int max_temp=0;
                    for (int k = 1; k <=j/weight[i-1] ; k<<=1) {
                        if (f[i-1][j-k*weight[i-1]]+k*value[i-1]>max_temp)
                            max_temp=f[i-1][j-k*weight[i-1]]+k*value[i-1];
                    }
                    f[i][j]=Math.max(f[i-1][j],max_temp);
                }else
                    f[i][j]=f[i-1][j];
            }
        }
        return f[n][w];
    }
    /*
    逆向思维
    在完全背包中，由于物品的件数无限，所以我们可以倒过来想，我们针对每个容量讨论，外循环为容量，
    对于每个容量j，我们求j对于所有物品能装载的最大价值，这样一来我们就能将时间复杂度降为O(N*V)了
     */
    private static int compeltePack1(int n,int w, int[] weight,int[] value){
        int[][] f=new int[w+1][n+1];
        int[] maxWeight=new int[w+1];
        for (int i = 1; i <=w ; i++) {
            int max_temp=0;
            for (int j = 1; j <=n ; j++) {
                if (i/weight[j-1]>=1){
                    f[i][j]=Math.max(maxWeight[i-1],maxWeight[i-weight[j-1]]+value[j-1]);
                }else
                    f[i][j]=maxWeight[i-1];
                if (f[i][j]>max_temp)
                    max_temp=f[i][j];
            }
            maxWeight[i]=max_temp;
        }
        return maxWeight[w];
    }
    //
    private static int compeltePack2(int n,int w, int[] weight,int[] value){
        int[] f=new int[w+1];
        for (int i = 0; i <n ; i++) {
            for (int j = weight[i]; j <=w; j++) {
                f[j]=Math.max(f[j],f[j-weight[i]]+value[i]);
            }
        }
        return f[w];
    }
}
package NiuKe.beibaodu;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/27.
 * 背包问题：多重背包-二进制优化。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();//物品的数量。
            int w = scanner.nextInt();//背包的容量。

            int[] count = new int[n];//物品的数量。
            int[] weight = new int[n];//物品的体积或者重量。
            int[] value = new int[n];//物品的价值。
            for (int i = 0; i < n; i++) {
                count[i] = scanner.nextInt();
                weight[i] = scanner.nextInt();
                value[i] = scanner.nextInt();
            }
            System.out.println(compeltePack(n,w,weight,value,count));
        }
    }
    private static int compeltePack(int n,int w, int[] weight,int[] value,int[] count){
        int[][] f=new int[n+1][w+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=w ; j++) {
                /*
                int max_temp=0;
                for (int k = 0; k <=count[i-1] ; k++) {
                    if (f[i-1][j-k*weight[i-1]]+k*value[i-1]>max_temp)
                        max_temp=f[i-1][j-k*weight[i-1]]+k*value[i-1];
                }
                f[i][j]=max_temp;
                 */
                if (j/weight[i-1]>=1){
                    int max_temp=0;
                    int num=Math.min(j/weight[i-1],count[i-1]);
                    for (int k = 1; k <=num ; k++) {
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
}

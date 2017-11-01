package WanMeiShiJie.QiuZhao2017;

import java.util.Scanner;

/**
 * Created by tzy on 2017/11/1.
 */
public class Main {
    private static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int n;
        int porit;
        int[][] weight;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            n = cin.nextInt();
            porit = cin.nextInt();
            weight = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int t = cin.nextInt();
                    t = t == -1 ? MAX :t;
                    weight[i][j] = t;
                }
            }
            dijkst(n, porit, weight);
        }
        cin.close();
    }
    public static void dijkst(int n, int p, int[][] weight) {
        int[] dist = new int[n]; //记录最小距离
        int[] s = new int[n]; //记录是否被访问，-1表示未访问，其他表示访问次序
        int order = 0; //记录访问顺序，每次+1
        for(int k=0;k<n;k++) {  //初始化

            dist[k] = weight[p][k];
            s[k] = -1;
        }

        s[p] = 0;
        dist[p] = 0;

        for(int m=0;m<n-1;m++) {
            int u = min(dist, s);
            order++;
            s[u] = order;
            for(int i=0;i<n;i++) {
                if(s[i] == -1) {
                    if(dist[u]!=MAX && weight[u][i]!=MAX) {
                        if(dist[u]+weight[u][i] < dist[i])
                            dist[i] = dist[u]+weight[u][i];
                    }
                }
            }
        }
        for(int j=0;j<n;j++) {
            if (p!=j)
                System.out.print(dist[j]);
            if (j < n-1 && j >0) System.out.print(",");
        }
        System.out.println();
    }
    private static int min(int[] dist, int[] small) {
        int min = 0;
        for (int i = 0; i < dist.length; i++) {
            while (small[min] != -1)

                min++;
            if (small[i] == -1) {
                if (dist[i] < dist[min])
                    min = i;
            }
        }
        return min;
    }
}


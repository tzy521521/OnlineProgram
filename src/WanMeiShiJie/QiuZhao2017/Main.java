package WanMeiShiJie.QiuZhao2017;

import java.util.Scanner;

/**
 * Created by tzy on 2017/11/1.
 * Dijkstra(迪杰斯特拉)单源最短路径,邻接矩阵实现。
 * 求出p点到其他节点(顺序从0到n)的距离，
 */
public class Main {
    private static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int n;
        int p;
        int[][] weight;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            p = scanner.nextInt();
            weight = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int t = scanner.nextInt();
                    t = t == -1 ? MAX :t;
                    weight[i][j] = t;
                }
            }
            dijkst(n, p, weight);
            int[] cost=dijkstra0(n,p,weight);
            for(int j=0;j<n-1;j++) {
                if (p!=j)
                    System.out.print(cost[j]+",");
            }
            System.out.println(cost[n-1]);
        }
    }
    public static int[] dijkstra0(int n, int p, int[][] weight){
        int[] cost=new int[n];//记录点v到点p的代价。
        for (int i = 0; i <n ; i++) {
            cost[i]=Integer.MAX_VALUE;
        }
        cost[p]=0;

        int[] parent=new int[n];//记录v节点的父节点。这个题，可以不用记录。
        parent[p]=-1;

        boolean[] flag=new boolean[n];//记录是否被访问
        int count=0;//T中的节点个数

        while (count<n){
            int currentMinCost=Integer.MAX_VALUE;
            int u=-1;
            for (int i = 0; i <n ; i++) {
                //在V-T中找到最小开销的定点u,初始时-1;
                if (!flag[i]&&cost[i]<currentMinCost){
                    currentMinCost=cost[i];
                    u=i;
                }
            }
            flag[u]=true;
            count++;
            for (int v = 0; v <n ; v++) {
                if (!flag[v]&&weight[u][v]<Integer.MAX_VALUE&&cost[v]>cost[u]+weight[u][v]){
                    //为每个在V-T中，并且和u相邻的顶点v(weight[u][v]<Integer.MAX_VALUE),更新cost[v];
                    cost[v]=cost[u]+weight[u][v];
                    parent[v]=u;
                }
            }
        }
        return cost;
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


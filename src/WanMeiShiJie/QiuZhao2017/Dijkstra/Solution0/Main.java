package WanMeiShiJie.QiuZhao2017.Dijkstra.Solution0;

import java.util.Scanner;

/**
 * Created by tzy on 2017/11/1.
 * Dijkstra(迪杰斯特拉)单源最短路径,邻接矩阵实现。
 * 求出p点到其他节点(顺序从0到n)的距离。
 * @author lp
 */
public class Main {
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
                    t = t == -1 ?Integer.MAX_VALUE :t;
                    weight[i][j] = t;
                }
            }
            int[] cost=dijkstra(n,p,weight);
            for(int j=0;j<n-1;j++) {
                if (p!=j){
                    System.out.print(cost[j]+",");
                }
            }
            System.out.println(cost[n-1]);
        }
    }
    private static int[] dijkstra(int n, int p, int[][] weight){
        //记录点v到点p的代价。
        int[] cost=new int[n];
        for (int i = 0; i <n ; i++) {
            cost[i]=Integer.MAX_VALUE;
        }
        cost[p]=0;

        //记录是否被访问
        boolean[] flag=new boolean[n];
        //T中的节点个数
        int count=0;

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
                }
            }
        }
        return cost;
    }
}
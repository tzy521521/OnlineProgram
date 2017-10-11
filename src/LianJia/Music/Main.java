package LianJia.Music;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            p=scanner.nextInt();
            for (int i=0;i<=p;i++)
                for (int j=0;j<=n;j++)
                    dp[i][j]=-1;
            System.out.println(dfs(0,0));
        }
    }
    static long dp[][] = new long[105][105];
    static int n,m,p;
    static int mo = 1000000007;
    public static long dfs(int i,int j){
        if(dp[i][j] != -1)
            return dp[i][j];
        if(i==p){
            if(j==n){
                dp[i][j]=1;
                return 1;
            }else{
                dp[i][j]=0;
                return 0;
            }
        }
        dp[i][j]=0;
        if(j>m)
            dp[i][j] = dfs(i+1,j)*(j-m);
        if(j<n)
            dp[i][j] += dfs(i+1,j+1)*(n-j);
        if(dp[i][j]>=mo)
            dp[i][j] %= mo;
        return dp[i][j];
    }
}


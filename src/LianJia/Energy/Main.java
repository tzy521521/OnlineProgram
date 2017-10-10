package LianJia.Energy;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();//玩具
        int m =sc.nextInt();//绳子
        int ae[]=new int[n];
        for(int i=0;i<n;i++) {
            ae[i] = sc.nextInt();
        }
        int la[][] = new int[m][2];
        for(int i=0;i<m;i++) {
            for(int j=0;j<2;j++) {
                la[i][j] = sc.nextInt();
            }
        }
        System.out.println(f(m,n,ae,la));
    }
    private static int f(int m,int n, int ae[],int la[][]) {
        int s=0;
        for(int i=0;i<m;i++) {
            int a = la[i][0];
            int b = la[i][1];
            if(ae[a-1]>ae[b-1])
                s+=ae[b-1];
            else s+=ae[a-1];
        }
        return s;
    }
}

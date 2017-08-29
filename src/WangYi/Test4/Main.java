package WangYi.Test4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tzy on 2017/3/26.
 */
class Matrix{
    public long[][] mat;
    public static int n;
    public static long k;

    public Matrix() {
        mat=new long[n][n];
    }
    public void powerMatrix(long k){
        //单位矩阵
        this.identityMatrix();

        Matrix tmp=new Matrix();
        tmp.initMatrix();
        while (k!=0){
            if ((k&1)==1)
                this.mat=this.mulMatrix(tmp).mat;
            k>>=1;
            tmp.mat=tmp.mulMatrix(tmp).mat;
        }
    }

    public Matrix mulMatrix(Matrix b){
        Matrix res=new Matrix();
        for (int i=0;i<n;i++){
            for (int j = 0; j <n ; j++) {
                res.mat[i][j]=0;
                for (int k = 0; k <n; k++) {
                    res.mat[i][j]+=this.mat[i][k]*b.mat[k][j];
                    res.mat[i][j]%=100;
                }
            }
        }
        return res;
    }

    //单位矩阵
    public void identityMatrix(){
        for (int i = 0; i <n ; i++) {
            Arrays.fill(mat[i],0);
        }
        for (int i = 0; i <n ; i++) {
            mat[i][i]=1;
        }
    }

    //初始化操作矩阵
    public void initMatrix(){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (i==j||(i+1)%n==j)
                    mat[i][j]=1;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            long k=sc.nextLong();
            int[] array=new int[n];
            Matrix.n=n;
            Matrix.k=k;
            for (int i = 0; i <n ; i++) {
                array[i]=sc.nextInt();
            }
            solve(n,k,array);
        }
    }
    public static void solve(int n,long k,int[] a){
        Matrix ans=new Matrix();
        ans.powerMatrix(Matrix.k);

        int[] b=new int[n];
        for (int i = 0; i <n ; i++) {
            b[i]=0;
            for (int j = 0; j <n ; j++) {
                b[i]+=ans.mat[i][j]*a[j];
                b[i]%=100;
            }
        }
        print(b);
    }
    public static void print(int [] array){
        for (int i = 0; i <array.length-1 ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println(array[array.length]-1);
    }
}

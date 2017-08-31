package WangYi.ChunZhao2017.MagicBracelet;

import java.util.Scanner;

/**
 * Created by tzy on 2017/3/26.
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：
 * 每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模
 * (比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 * 利用矩阵快速幂算法。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] array=new int[n];
            for (int i = 0; i <n ; i++) {
                array[i]=sc.nextInt();
            }
            int[] result=solve(array,k);
            for (int i = 0; i <result.length-1 ; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println(result[result.length-1]);
        }
    }
    public static int[] solve(int[] array,int k){
        Matrix initMatrix=new Matrix(array.length);
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array.length ; j++) {
                if (i==j||(i-1)==j)
                    initMatrix.mat[i][j]=1;
            }
        }
        initMatrix.mat[0][array.length-1]=1;
        //求操作矩阵的幂
        Matrix temp=initMatrix.powerMatrix(k);
        //k次变换后的结果
        int[] result=new int[array.length];
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array.length ; j++) {
                result[i]+=array[j]*temp.mat[j][i];
                result[i]=result[i]%100;
            }
        }
        return result;
    }
    public static class Matrix{
        public int[][] mat;
        public int n;
        //初始化n阶方阵。
        public Matrix(int n) {
            this.n = n;
            init();
        }
        //从一个二维数组中创建一个方针
        public Matrix(int[][] array){
            this.n=array.length;
            mat=new int[array.length][array[0].length];
            for (int i = 0; i <array.length ; i++) {
                for (int j = 0; j <array[0].length ; j++) {
                    this.mat[i][j]=array[i][j];
                }
            }
        }
        public void init(){
            mat=new int[n][n];
        }
        //生成n阶单位矩阵
        public static Matrix identityMatrix(int n){
            Matrix identity=new Matrix(n);
            for (int i = 0; i <n ; i++) {
                identity.mat[i][i]=1;
            }
            return identity;
        }

        //方阵相乘
        public Matrix mulMatrix(Matrix b){
            Matrix res=new Matrix(n);
            for (int i=0;i<n;i++){
                for (int j = 0; j <n ; j++) {
                    for (int k = 0; k <n; k++) {
                        res.mat[i][j]+=this.mat[i][k]*b.mat[k][j];
                        res.mat[i][j]%=100;
                    }
                }
            }
            return res;
        }
        //方阵的幂次方。
        public Matrix powerMatrix(int k){
            Matrix identity= Matrix.identityMatrix(n);
            Matrix base=new Matrix(this.mat);
            //矩阵快速幂
            while (k!=0)
            {
                if ((k&1)==1)
                    identity=identity.mulMatrix(base);
                base=base.mulMatrix(base);
                k>>=1;
            }
            return identity;
        }
    }
}

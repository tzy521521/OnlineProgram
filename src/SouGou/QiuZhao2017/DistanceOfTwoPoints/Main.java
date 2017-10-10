package SouGou.QiuZhao2017.DistanceOfTwoPoints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tzy on 2017/10/10.
 * 定义圆周上两点的距离s为这两点之间的劣弧对应的圆心角度数(0<=s<=180)，现输入圆周上的n个点（n>=2），
 * 以角度a表示其位置(0<=a<360)，输入按a从小到大排序。求最远的一对点之间的距离。
 */
public class Main {
    public static void main(String args[]) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int n = Integer.valueOf(br.readLine());
        double[] f = new double[n];
        for (int i = 0; i < n; i++) {
            f[i] = Double.valueOf(br.readLine());
        }

        double max = 0.0;   //圆上两点最后输出的最大距离
        int samll = 0;      //开始指针
        int big = 1;        //跟进指针

        while(big < n){
            //定义两点距离diff
            double diff = f[big] - f[samll];
            //如果diff超过180
            if(Double.compare(diff , 180.0) > 0){
                double dif = Math.abs(f[big] - f[samll]);
                //dif大于180就取（360-dif）,反之则取dif
                double dist=360.0 - dif;
                //如果测试的两个点的距离大于max则将dist赋给max。同时small往后移动
                if(dist > max)
                    max = dist;
                samll++;
            }else{
                //diff大于max则big往后移，（刚开始是一直往后移，直到大于180为止）
                if(diff > max)
                    max = diff;
                big++;
            }
        }
        System.out.printf("%.8f\n" , max);
    }
}

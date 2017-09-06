package HuaWei.QiuZhao2017_2.JiuTong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/6.
 * 酒馆有m个龙头可供顾客们接啤酒，每个龙头每秒的出酒量相等，都是1.现在有n名顾客准备接酒，
 * 他们的接酒顺序是确定的。将这些顾客接酒的顺序从1到n编号，i号顾客的接酒量是w_i。
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[] jiu=new int[n];
            for (int i = 0; i <n ; i++) {
                jiu[i]=scanner.nextInt();
            }
            System.out.println(timeOut(jiu,m));
        }
    }
    public static int timeOut(int[] jiu,int m){
        if (jiu.length<=m){
            Arrays.sort(jiu);
            return jiu[jiu.length-1];
        }
        int[] shLong=new int[m];
        for (int i = 0; i <m ; i++) {
            shLong[i]=jiu[i];
        }
        int time=0;
        int index=m;
        while (index<jiu.length){
            Arrays.sort(shLong);
            int min=shLong[0];
            time+=min;
            for (int j = 0; j <shLong.length; j++) {
                shLong[j]-=min;
            }
            for (int j = 0; j <shLong.length ; j++) {
                if (shLong[j]==0){
                    if (index!=jiu.length)
                        shLong[j]=jiu[index++];
                    else
                        break;
                }
            }
        }
        Arrays.sort(shLong);
        return time+shLong[shLong.length-1];
    }
}

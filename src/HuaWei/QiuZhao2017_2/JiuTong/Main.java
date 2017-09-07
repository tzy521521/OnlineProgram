package HuaWei.QiuZhao2017_2.JiuTong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/6.
 * 酒馆有m个龙头可供顾客们接啤酒，每个龙头每秒的出酒量相等，都是1.现在有n名顾客准备接酒，他们的接酒顺序是确定的。
 * 将这些顾客接酒的顺序从1到n编号，i号顾客的接酒量是w_i。接酒开始时，1到m号顾客各占一个酒龙头，并同时打开龙头接酒。
 * 当其中某个顾客j完成其接酒量要求w_j后。下一名排队等候接酒的顾客k马上接替j顾客的位置开始接酒。
 * 若当前接酒人数n不足m,则只有n个龙头供酒，其他m-n个龙头关闭。
 * 现在给出n名顾客的接酒量，按照上述规则，问所有顾客都接完酒需要多少秒。
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

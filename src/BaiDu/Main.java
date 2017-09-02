package BaiDu;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/2.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int t=scanner.nextInt();
            int c=scanner.nextInt();
            int[] zuixing=new int[n];
            for (int i = 0; i <n ; i++) {
                zuixing[i]=scanner.nextInt();
            }
            System.out.println(total(zuixing,c,t));
        }
    }
    public static int total(int[] zuixing,int c,int t){
        if (c>zuixing.length)
            return 0;
        int low=0;int height=c-1;
        int sum=0;int num=0;
        for (int i = low; i <height ; i++) {
            sum+=zuixing[i];
        }
        for (int i = height; i <zuixing.length ; i++) {
            sum+=zuixing[i];
            if (sum<t)
                num++;
            else {
                sum-=zuixing[low];
                low++;
            }
        }
        return num;
    }
}

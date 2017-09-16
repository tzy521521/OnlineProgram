package MeiTuan.QiuZhao2017.sd;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] num=new int[n];
            for (int i = 0; i <n ; i++) {
                num[i]=scanner.nextInt();
            }
            if (num[n-1]==0)
                System.out.println("Alice");
            else
                System.out.println("Bob");

        }
    }
}

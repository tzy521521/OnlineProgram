package Unicom.Hannotta;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/20.
 * 经典汉诺塔问题。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in );
        while (in.hasNext()){
            int nDisks=in.nextInt();
            doTowers(nDisks, 'A', 'B', 'C');
        }
    }
    private static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1){
            System.out.println(from + "-"+1+"-"+to);
        }else {
            doTowers(topN - 1, from, to, inter);
            System.out.println(from + "-"+topN+"-" + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}
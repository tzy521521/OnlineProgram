package lianton.dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in );
        int nDisks=in.nextInt();
        doTowers(nDisks, 'A', 'B', 'C');
    }
    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1){
            System.out.println(
                    from + "-"+1+"-"+to);
        }else {
            doTowers(topN - 1, from, to, inter);
            System.out.println(
                    from + "-"+topN+"-" + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}

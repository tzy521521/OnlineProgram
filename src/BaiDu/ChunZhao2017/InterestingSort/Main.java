package BaiDu.ChunZhao2017.InterestingSort;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by tzy on 2017/9/2.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            TreeSet<Integer> treeSet=new TreeSet<>();
            for (int i = 0; i <num ; i++) {
                treeSet.add(scanner.nextInt());
            }
            int index=0;
            for (Integer integer:treeSet) {
                index++;
                if (index==3){
                    System.out.println(integer);
                    break;
                }
            }
            if (index<3)
                System.out.println(-1);
        }
    }
}

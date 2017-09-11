package WangYi.Qiuzhao2017_neitui.ArithmeticalSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tzy on 2017/8/31.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            int[]temp=new int[num];
            ArrayList<Integer> arrayList=new ArrayList<>();
            for (int i = 0; i <num ; i++) {
                temp[i]=scanner.nextInt();
                arrayList.add(temp[i]);
            }
            System.out.println(ispossible(arrayList));
        }
    }
    public static String ispossible(ArrayList<Integer> arrayList){
        Collections.sort(arrayList);
        if (arrayList.size()<=2){
            return "Possible";
        } else {
            int de=arrayList.get(1)-arrayList.get(0);
            int k=2;
            for (int i = 2; i <arrayList.size() ; i++) {
                if (arrayList.get(k)-arrayList.get(k-1)!=de){
                    return"Impossible";
                }
            }
        }
        return "Possible";
    }
}

package WanMeiShiJie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by tzy on 2017/3/29.
 * 赛码网。背包问题。
 * 我用的最笨的办法。
 */
class Prize  {
    int value;
    int weight;

    public Prize() {
    }
}

public class Main {
    public static  int val(ArrayList<Prize> arrayList, int weights){
        int max_values=0;
        Collections.sort(arrayList, new Comparator<Prize>() {
            @Override
            public int compare(Prize o1, Prize o2) {
                Integer a=o1.weight;
                Integer b=o2.weight;
                return a.compareTo(b);
            }
        });
        for (int i=arrayList.size()-1;i>0;i--){
            int weight_temp=arrayList.get(i).weight;
            int values=arrayList.get(i).value;
            for (int j=i-1;j>=0;j--){
                weight_temp+=arrayList.get(j).weight;
                values+=arrayList.get(j).value;
                if (weight_temp>weights){
                    weight_temp-=arrayList.get(j).value;
                    values-=arrayList.get(j).value;
                    continue;
                }
            }
            if (max_values<values)
                max_values=values;
        }
        return max_values;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<Prize> arrayList=new ArrayList();
            for (int i = 0; i <n ; i++) {
                Prize prize=new Prize();
                prize.value=scanner.nextInt();
                arrayList.add(prize);
            }
            for (int i = 0; i <arrayList.size() ; i++) {
                arrayList.get(i).weight=scanner.nextInt();
            }
            int weights=scanner.nextInt();
            System.out.println(val(arrayList,weights));
        }

    }
}

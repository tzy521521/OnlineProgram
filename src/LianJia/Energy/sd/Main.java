package LianJia.Energy.sd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by tzy on 2017/10/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            ArrayList<WanCast> arrayList=new ArrayList<>();
            ArrayList<ArrayList<WanCast>> arrayLists=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                arrayList.add(new WanCast(i+1,scanner.nextInt()));
                arrayLists.add(new ArrayList<>());
            }
            for (int i = 0; i <m ; i++) {
                int index0=scanner.nextInt();
                int index1=scanner.nextInt();
                arrayLists.get(index0-1).add(arrayList.get(index1-1));
                arrayLists.get(index1-1).add(arrayList.get(index0-1));
            }
            System.out.println(getMinEnergy(arrayList,arrayLists));
        }
    }
    private static int getMinEnergy(ArrayList<WanCast> list,ArrayList<ArrayList<WanCast>> arrayLists){
        Collections.sort(list, new Comparator<WanCast>() {
            @Override
            public int compare(WanCast o1, WanCast o2) {
                return Integer.compare(o1.getEnergy(),o2.getEnergy());
            }
        });
        int minEnergy=0;
        //3层for循环？？
        for (int i = list.size()-1; i >=0 ; i--) {
            WanCast wanCast=list.get(i);
            ArrayList<WanCast>temp=arrayLists.get(wanCast.getIndex()-1);
            for (WanCast w:temp) {
                minEnergy+=w.getEnergy();
                ArrayList<WanCast> shan=arrayLists.get(w.getIndex()-1);
                for (int j = 0; j <shan.size() ; j++) {
                    if (shan.get(j).getIndex()==wanCast.getIndex()){
                        shan.remove(j);
                        break;
                    }
                }
            }
        }
        return minEnergy;
    }
    static class WanCast{
        private int index;
        private int energy;

        public WanCast(int index, int energy) {
            this.index = index;
            this.energy = energy;
        }

        public int getIndex() {
            return index;
        }

        public int getEnergy() {
            return energy;
        }
    }
}

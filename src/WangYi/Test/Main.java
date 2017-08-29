package WangYi.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/3/25.
 * 魔力手环。
 * 最笨的办法~~~没有用到什么算法~~~
 */
public class Main {
    public static void main(String[] args) {
        Scanner inpu =new Scanner(System.in);

        while (inpu.hasNext()){
            ArrayList<Integer> arrayList=new ArrayList();
            int n=inpu.nextInt();
            int k=inpu.nextInt();
            while (n!=0){
                arrayList.add(inpu.nextInt());
                n--;
            }
            arrayList=Megic(k,arrayList);
            for (int i=0;i<arrayList.size()-1;i++){
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println(arrayList.get(arrayList.size()-1));
        }
    }
    public static ArrayList<Integer> Megic(int k, ArrayList<Integer> arrayList){
        int height=arrayList.size()-1;
        while (k!=0){
            int temp=arrayList.get(height)+arrayList.get(0);
            if (temp>100)
                temp=temp%100;
            for (int i=0;i<height;i++){
                int temp1=arrayList.get(i)+arrayList.get(i+1);

                if (temp1>100)
                temp1=temp1%100;
                arrayList.set(i,temp1);
            }
            arrayList.set(height,temp);
            k--;
        }
        return arrayList;
    }
}

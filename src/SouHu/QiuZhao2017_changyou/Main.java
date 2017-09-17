package SouHu.QiuZhao2017_changyou;

import java.util.*;

/**
 * Created by tzy on 2017/9/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            long n=scanner.nextLong();
            HashSet<Long> hashSet=new HashSet<>();
            for (long i = 0; i <n ; i++) {
                hashSet.add(scanner.nextLong());
            }
            ArrayList<Long> arrayList=new ArrayList<>(hashSet);
            System.out.println(secodMax(arrayList));
        }
    }
    private static long secodMax(ArrayList<Long> arrayList){
        if (arrayList==null)
            return 0;
        if (arrayList.size()==1)
            return arrayList.get(0);
        long[] temp=new long[2];
        for (int i = 0; i <arrayList.size() ; i++) {
            if (arrayList.get(i)>temp[0]){
                temp[0]=arrayList.get(i);
                if (temp[0]>temp[1]){
                    long t=temp[1];
                    temp[1]=temp[0];
                    temp[0]=t;
                }
            }
        }
        return temp[0];
    }
    /*
    private static long secodMax(ArrayList<Long> arrayList){
        if (arrayList==null)
            return 0;
        if (arrayList.size()==1)
            return arrayList.get(0);
        Collections.sort(arrayList);
        return arrayList.get(arrayList.size()-2);
    }
     */

}

package lianton;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<Long> arrayList=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                arrayList.add(scanner.nextLong());
            }
            System.out.println(maxPrice(arrayList));
        }
    }
    public static long maxPrice(ArrayList<Long> arrayList){
        long max=0;
        int cout=1;
        ArrayList<Long> temp=new ArrayList<>();
        temp.addAll(arrayList);

        int low=0;int heigh=arrayList.size()-1;
        while (temp.size()>0){
            if (temp.get(0)<temp.get(temp.size()-1)){
                max+=temp.get(0);
                temp.remove(0);
                low++;
            } else {
                max+=temp.get(temp.size()-1);
                temp.remove(temp.size()-1);
                heigh--;
            }

            cout++;
            if (temp.size()>0){
                int index=0;
                for (int i = low; i <=heigh ; i++) {
                    long price=arrayList.get(i)*cout;
                    temp.set(index++,price);
                }
            }else
                break;
        }
        return max;
    }
}

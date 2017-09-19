package BaiDu.QiuZhao2017;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tzy on 2017/9/19.
 */
public class Main {
    public static void main(String[] args) {
        int[] health={9,8,2,5};
        System.out.println(minimumNumberOfGunShots(4,3,1,health));
    }
    public static int minimumNumberOfGunShots(int num, int shotDegrade, int remDegrade, int[] health){
        // WRITE YOUR CODE HERE
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int ta:health){
            arrayList.add(ta);
        }
        Collections.sort(arrayList);
        int tatol=0;
        while(arrayList.size()>0){
            int index=0;
            if(arrayList.get(arrayList.size()-1)>0)
                tatol++;
            while(arrayList.size()>0) {
                if (arrayList.get(index)<=remDegrade)
                    arrayList.remove(index);
                else
                    break;
            }
            if (arrayList.size()>0){
                while(arrayList.size()>0&&index<arrayList.size()-1) {
                    int temp=arrayList.get(index)-remDegrade;
                    arrayList.set(index,temp);
                    index++;
                }
                int temp1=arrayList.get(arrayList.size()-1)-shotDegrade;
                arrayList.set(index,temp1);
                Collections.sort(arrayList);
            }
            else
                break;
        }
        return tatol;
    }
}

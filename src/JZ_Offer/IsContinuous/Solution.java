package JZ_Offer.IsContinuous;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tzy on 2017/8/18.
 * 认为大小王是0
 */
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers==null||numbers.length<1)
            return false;
        int num=0;
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i <numbers.length; i++) {
            if (numbers[i]!=0)
                arrayList.add(numbers[i]);
            else
                num++;
        }
        Collections.sort(arrayList);
        int start=arrayList.get(0);
        int index=1;
        while (index<arrayList.size()){
            if (arrayList.get(index)==++start)
                index++;
            else {
                if (num>0){
                    num--;
                }else
                    return false;
            }
        }
        return true;
    }
}

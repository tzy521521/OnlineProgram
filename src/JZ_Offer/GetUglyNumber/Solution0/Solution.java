package JZ_Offer.GetUglyNumber.Solution0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by tzy on 2017/8/17.
 */
public class Solution {
    public Long GetUglyNumber_Solution(int index) {
        if (index<1)
            return 0L;
        ArrayList<Long> arrayList=new ArrayList<>();
        arrayList.add(1L);
        int i=0;
        while (true){
            HashSet<Long> hashSet=new HashSet<>();
            while (i<arrayList.size()){
                hashSet.add(2*arrayList.get(i));
                hashSet.add(3*arrayList.get(i));
                hashSet.add(5*arrayList.get(i));
                i++;
            }
            arrayList.addAll(hashSet);

            if (arrayList.size()>=2*index)
                break;
        }
        Collections.sort(arrayList);
        return arrayList.get(index-1);
    }
}

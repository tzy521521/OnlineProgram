package JZ_Offer.ReOrderArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzy on 2017/3/22.
 */
public class Solution {
    public int[] reOrderArray(int [] array) {
        if (array==null||array.length==0)
            return null;
        List<Integer> arrayList=new ArrayList<>();
        List<Integer> arrayList1=new ArrayList<>();
        for (int i:array) {
            if (i%2==1)
                arrayList.add(i);
            else
                arrayList1.add(i);
        }
        int k=0;
        while (k<arrayList.size())
            array[k]=arrayList.get(k++);
        int j=0;
        while (j<arrayList1.size())
            array[k++]=arrayList1.get(j++);
        return array;
    }
}

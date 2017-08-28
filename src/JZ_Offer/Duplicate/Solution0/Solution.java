package JZ_Offer.Duplicate.Solution0;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tzy on 2017/8/18.
 */
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null)
            return false;
        LinkedHashMap<Integer,Integer> linkedHashMap=new LinkedHashMap<>();
        for (int i = 0; i <length ; i++) {
            if (linkedHashMap.containsKey(numbers[i])){
                int val=linkedHashMap.get(numbers[i]);
                val++;
                linkedHashMap.put(numbers[i],val);
            }else {
                linkedHashMap.put(numbers[i],1);
            }
        }
        int k=0;
        Iterator iter = linkedHashMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            if ((int)entry.getValue()>1){
                duplication[k++]=(int)entry.getKey();
                return true;
            }
        }
        return false;
    }
}

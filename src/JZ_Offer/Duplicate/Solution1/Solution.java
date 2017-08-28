package JZ_Offer.Duplicate.Solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tzy on 2017/8/18.
 * 数组中任意一个重复的数字
 */
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null)
            return false;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        /*
        for (int i = 0; i <length ; i++) {
            if (hashMap.containsKey(numbers[i])){
                int val=hashMap.get(numbers[i]);
                val++;
                hashMap.put(numbers[i],val);
            }else {
                hashMap.put(numbers[i],1);
            }
        }
         */
        for (int i = 0; i <length ; i++) {
            hashMap.put(numbers[i],hashMap.getOrDefault(numbers[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()) {
            if (entry.getValue()>1){
                duplication[0]=entry.getKey();
                return true;
            }
        }
        return false;
    }
}

package JZ_Offer.Duplicate.Solution0;

import java.util.HashMap;

/**
 * Created by tzy on 2017/8/18.
 * 数组中第一个重复的数字，需要额外的空间。
 */
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null){
            duplication[0]=-1;
            return false;
        }
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int num:numbers) {
            if (hashMap.containsKey(num)){
                duplication[0]=num;
                return true;
            }
            else
                hashMap.put(num,1);
        }
        return false;
    }
}

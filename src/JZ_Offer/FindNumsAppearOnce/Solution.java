package JZ_Offer.FindNumsAppearOnce;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tzy on 2017/4/1.
 *
 */
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        boolean flag=false;
        for (int i = 0; i <array.length ; i++) {
            /*
            if (!hashMap.containsKey(array[i]))
                hashMap.put(array[i],1);
            else {
                int value=hashMap.get(array[i]);
                value++;
                hashMap.put(array[i],value);
            }
             */

            //java8的API。
           hashMap.put(array[i],hashMap.getOrDefault(array[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()) {
            if (entry.getValue()==1){
                if (flag){
                    num2[0]=entry.getKey();
                    break;
                }
                num1[0]=entry.getKey();
                flag=true;
            }
        }
    }
}

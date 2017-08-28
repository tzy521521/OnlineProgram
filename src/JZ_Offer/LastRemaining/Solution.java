package JZ_Offer.LastRemaining;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/8/18.
 */
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n==0)
            return -1;
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            arrayList.add(i);
        }
        //index表示开始新一轮开始喊数字的孩子的下标。
        int index=0;
        while (arrayList.size()!=1){
            for (int i = 0; i <m ; i++) {
                ++index;
                if (index>arrayList.size()-1)
                    index=0;
            }
            if (index==0)
                arrayList.remove(arrayList.size()-1);
            else
                arrayList.remove(--index);
        }
        return arrayList.get(0);
    }
}

package JZ_Offer.MaxInWindows;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tzy on 2017/3/23.
 * 复制一维数组的一部分。
 * 题目隐含要求如果数组长度小于滑动窗口，返回空。
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (size>0){
            for (int i=0;i<=num.length-size;i++){
                //int[] temp =Arrays.copyOfRange(num,i,i+size);
                int[] temp=new int[size];
                System.arraycopy(num,i,temp,0,size);
                Arrays.sort(temp);
                arrayList.add(temp[size-1]);
            }
        }
        return arrayList;
    }
}

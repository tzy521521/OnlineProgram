package HuaWei.LIS.Solution1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tzy on 2017/8/29.
 * 最长递增子序列：只是求出长度。最好的情况O(n),最坏的情况是O(n2)
 */
public class Solution {
    public int length_LIS(int[] students){
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(students[0]);
        for (int i = 1; i <students.length ; i++) {
            if (arrayList.get(arrayList.size()-1)<students[i])
                arrayList.add(students[i]);
            else {
                /*
                int k=0;
                while (k<arrayList.size()-1){
                    if (arrayList.get(k)<students[i])
                        k++;
                    else
                        break;
                }
                arrayList.set(k,students[i]);
                 */
                //二分法找设置的位置
                int k= Collections.binarySearch(arrayList,students[i]);
                if (k<0)
                    arrayList.set(-k-1,students[i]);
            }
        }
        return arrayList.size();
    }
}

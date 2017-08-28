package JZ_Offer.MinNumberInRotateArray.Solution1;

import java.util.Arrays;

/**
 * Created by tzy on 2017/3/22.
 *Arrays类中的sort()使用的是“经过调优的快速排序法”。
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array==null||array.length==0)
            return 0;
        //Arrays.parallelSort(array);
        Arrays.sort(array);
        return array[0];
    }
}

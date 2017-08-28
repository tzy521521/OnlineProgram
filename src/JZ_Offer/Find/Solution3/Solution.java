package JZ_Offer.Find.Solution3;

import java.util.Arrays;

/**
 * Created by tzy on 2017/3/21.
 */
public class Solution {
    /**
     * 把二位数组的每一行看成有序递增的数组。使用二分查找。
     * Arrays类中有对数组进行二分查找的函数。代码较少。
     * 算法复杂度O(nlogn);
     */
    public boolean Find(int target, int [][] array) {
        int row=0;
        while (row<array.length){
            int flag=Arrays.binarySearch(array[row],target);
            if (flag>=0&flag<array[0].length)
                return true;
            else
                row++;
        }
        return false;
    }
}

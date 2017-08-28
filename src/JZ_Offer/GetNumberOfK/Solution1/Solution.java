package JZ_Offer.GetNumberOfK.Solution1;

import java.util.Arrays;

/**
 * Created by tzy on 2017/3/31.
 * 要求传入的数组必须满足题目要求，为有序的数组。
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k){
        int index=Arrays.binarySearch(array,k);
        if (index<0)
            return 0;
        int j=index,i=index;
        while (j<array.length){
            if (array[j]!=k)
                break;
            else
                j++;
        }
        while (i>=0){
            if (array[i]!=k)
                break;
            else
                i--;
        }
        return j-i-1;
    }
}

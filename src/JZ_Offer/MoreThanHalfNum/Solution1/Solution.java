package JZ_Offer.MoreThanHalfNum.Solution1;

import java.util.Arrays;

/**
 * Created by tzy on 2017/8/26.
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0)
            return 0;
        Arrays.sort(array);
        int half=array.length/2;
        int res=array[half];
        int low=half;int heigh=half;
        while (low>=0){
            if (array[low]==res)
                low--;
            else
                break;
        }
        while (heigh<array.length){
            if (array[heigh]==res)
                heigh++;
            else
                break;
        }
        if ((heigh-low-1)>half)
            return res;
        else
            return 0;
    }
}

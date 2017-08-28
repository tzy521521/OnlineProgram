package JZ_Offer.MoreThanHalfNum.Solution0;

import java.util.Arrays;

/**
 * Created by tzy on 2017/3/29.
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0)
            return 0;
        Arrays.sort(array);
        int half=array.length/2;
        int res=array[half];
        String tem=String.valueOf(res);
        String string=Arrays.toString(array);

        int start=string.indexOf(tem);
        int end=string.lastIndexOf(tem);
        int num=(end-start)/(tem.length()+2)+1;
        if (num>half)
            return res;
        else
            return 0;
    }
}

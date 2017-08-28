package JZ_Offer.GetNumberOfK.Solution0;

import java.util.Arrays;

/**
 * Created by tzy on 2017/3/31.
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k){
        String string=Arrays.toString(array);
        String temp=String.valueOf(k);
        int low=string.indexOf(temp);
        int height=string.lastIndexOf(temp);
        if (low==-1)
            return 0;
        return (height-low)/(temp.length()+2)+1;
    }
}

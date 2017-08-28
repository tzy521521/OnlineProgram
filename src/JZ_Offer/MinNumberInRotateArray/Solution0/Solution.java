package JZ_Offer.MinNumberInRotateArray.Solution0;

/**
 * Created by tzy on 2017/3/22.
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array==null||array.length==0)
            return 0;
        int low=0;
        int height=array.length-1;
        while (height>0){
            if (array[low]>=array[height])
                height--;
            else
                break;
        }
        return array[height+1];
    }
}

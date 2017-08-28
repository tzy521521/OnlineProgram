package JZ_Offer.RectCover.Solution0;

/**
 * Created by tzy on 2017/8/20.
 */
public class Solution {
    public int RectCover(int target) {
        if (target>0){
            if (target==1)
                return 1;
            else if(target==2)
                return 2;
            else
                return RectCover(target-1)+RectCover(target-2);
        }
        else
            return 0;
    }
}

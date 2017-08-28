package JZ_Offer.JumpFloorII.Solution0;

/**
 * Created by tzy on 2017/3/21.
 */
public class Solution {
    public int JumpFloorII(int target) {
        if (target>0)
            return (int)Math.pow(2,target-1);
        else
            return 0;
    }
}
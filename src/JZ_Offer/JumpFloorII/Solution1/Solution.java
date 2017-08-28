package JZ_Offer.JumpFloorII.Solution1;

/**
 * Created by tzy on 2017/3/21.
 */
public class Solution {
    public int JumpFloorII(int target) {
        if (target>0){
            if (target==1)
                return 1;
            else return 2*JumpFloorII(target-1);
        }
        else
            return 0;
    }
}
package JZ_Offer.JumpFloor.Solution0;

/**
 * Created by tzy on 2017/8/20.
 * 当台阶个数大于2的时候，最后要么跳1阶，要么调二阶。
 * 斐波那契，递归算法，算法复杂度O(2^n);
 */
public class Solution {
    public int JumpFloor(int target) {
        if (target>0){
            if (target==1)
                return 1;
            else if(target==2)
                return 2;
            else
                return JumpFloor(target-1)+JumpFloor(target-2);
        }
        else
            return 0;
    }
}

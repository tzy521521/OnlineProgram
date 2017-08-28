package JZ_Offer.Find.Solution0;

/**
 * Created by tzy on 2017/3/21.
 * 算法复杂度O(n^2);
 */
public class Solution {
    //最基本的普通遍历,使用增强for循环,代码最少。
    public boolean Find(int target, int [][] array) {
        for (int[] row:array){
            for (int col:row){
                if (target==col)
                    return true;
            }
        }
        return false;
    }
}

package JZ_Offer.TreeDepth;

/**
 * Created by tzy on 2017/3/31.
 */
public class Solution {
    public int TreeDepth(TreeNode root){
        if (root==null)
            return 0;
        int leftL=TreeDepth(root.left);
        int rightL=TreeDepth(root.right);
        return leftL>rightL?(leftL+1):(rightL+1);
    }
}

package JZ_Offer.Mirror;

/**
 * Created by tzy on 2017/3/28.
 */
public class Solution {
    public void Mirror(TreeNode root) {
        TreeNode temp=root;
        if (temp==null)
            return;
            temp=root.left;
            root.left=root.right;
            root.right=temp;
            Mirror(root.left);
            Mirror(root.right);
    }
}

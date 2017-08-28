package JZ_Offer.IsSymmetrical;

/**
 * Created by tzy on 2017/8/14.
 */
public class Solution {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null)
            return true;
        else
            return isSymmetrical(pRoot.left,pRoot.right);
    }
    public boolean isSymmetrical(TreeNode L,TreeNode R) {
        if (L==null&&R==null)
            return true;
        if (L==null||R==null)
            return false;
        if (L.val==R.val)
            return isSymmetrical(L.left,R.right)&&isSymmetrical(L.right,R.left);
        else
            return false;
    }


}

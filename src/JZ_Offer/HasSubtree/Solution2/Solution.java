package JZ_Offer.HasSubtree.Solution2;

/**
 * Created by tzy on 2017/3/28.
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2==null) return false;
        if(root1==null && root2!=null) return false;
        boolean flag=false;
        if(root1.val==root2.val){
            flag = isSubTree(root1,root2);
        }
        if(!flag){
            flag = HasSubtree(root1.left, root2);
            if(!flag){
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root1.val==root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else{
            return false;
        }
    }
}

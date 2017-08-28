package JZ_Offer.ReConstructBinaryTree.Solution2;

/**
 * Created by tzy on 2017/3/21.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] post={4,5,2,6,7,3,1};
        int[]   in={4,2,5,1,6,3,7};
        TreeNode treeNode= solution.reConstructBinaryTree(post,in);
        System.out.println(treeNode.val);
    }
}

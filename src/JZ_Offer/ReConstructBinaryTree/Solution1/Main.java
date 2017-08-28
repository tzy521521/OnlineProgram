package JZ_Offer.ReConstructBinaryTree.Solution1;

/**
 * Created by tzy on 2017/3/21.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] pre={1,2,3,4,5,6,7};
        int[] in={3,2,4,1,6,5,7};
        TreeNode root=solution.reConstructBinaryTree(pre,in);
        if (root!=null)
            System.out.println(root.val);
    }
}

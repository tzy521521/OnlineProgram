package JZ_Offer.Convert;

/**
 * Created by tzy on 2017/8/3.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] tree={4,2,6,1,3,5,7};
        BT bt=new BT(tree);
        TreeNode te=solution.Convert(bt.root);
        while (te!=null){
            System.out.print(te.val+" ");
            te=te.right;
        }
    }
}

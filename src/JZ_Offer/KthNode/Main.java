package JZ_Offer.KthNode;

/**
 * Created by tzy on 2017/8/14.
 */
public class Main {
    public static void main(String[] args) {
        int[] elem={8,6,10,5,7,9,11};

        BT bt=new BT(elem);
        Solution solution=new Solution();
        TreeNode result=solution.KthNode(bt.root,1);
        if (result!=null)
            System.out.println(result.val);
        System.out.println("!");
    }
}

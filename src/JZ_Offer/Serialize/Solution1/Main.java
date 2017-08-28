package JZ_Offer.Serialize.Solution1;

/**
 * Created by tzy on 2017/8/14.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        //int[] elem={1,2,3,4,5,6,7,8,9};
        int[] elem={3,9,20,0,0,15,7,0,0,0,0,0,8,0,0};
        BT bt=new BT(elem);

        String s=solution.Serialize(bt.root);
        System.out.println(s);

        TreeNode treeNode=solution.Deserialize(s);
        if (treeNode!=null)
            System.out.println(treeNode.val);
        System.out.println(solution.Serialize(treeNode));
    }
}

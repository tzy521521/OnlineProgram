package JZ_Offer.Serialize.Solution0;

/**
 * Created by tzy on 2017/8/14.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        //int[] elem={3,9,20,0,0,15,7,0,0,0,0,8,6,0,0};
        int[] elem={};
        BT bt=new BT(elem);

        //层次系列化
        String s=solution.Serialize(bt.root);
        System.out.println(s);

        //层次返序列化
        TreeNode root=solution.Deserialize(s);
        if (root!=null)
            System.out.println(root.val);

        //验证反序列化
        String s1=solution.Serialize(root);
        System.out.println(s1);

        //层次返序列化
        TreeNode root0=solution.Deserialize("{100,50,#,#,150}");
        if (root0!=null)
            System.out.println(root0.val);

        //验证反序列化
        String s2=solution.Serialize(root0);
        System.out.println(s2);

    }
}

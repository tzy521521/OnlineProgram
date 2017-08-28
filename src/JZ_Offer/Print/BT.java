package JZ_Offer.Print;

/**
 * Created by tzy on 2017/8/13.
 */
public class BT {

    protected TreeNode root;

    public BT(int[] objects) {
        root=creatTree(objects,0);
    }

    private TreeNode creatTree(int[] objects, int i){
        TreeNode parent;
        if (i>=objects.length||objects[i]==0)
            return null;
        else {
            parent=new TreeNode(objects[i]);
            parent.left=creatTree(objects,2*i+1);
            parent.right=creatTree(objects,2*i+2);
            return parent;
        }
    }
}

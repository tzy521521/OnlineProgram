package JZ_Offer.ReConstructBinaryTree.Solution1;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Created by tzy on 2017/3/21.
 * 根据某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        //递归终止条件~~~~
        if(pre.length == 0||in.length == 0||pre.length!=in.length){
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);
        for (int i=0;i<in.length;i++){
            if (in[i]==pre[0]){
                //左子树
                /*
                int[] left_pre= Arrays.copyOfRange(pre,1,i+1);
                int[] left_in=Arrays.copyOfRange(in,0,i);
                 */
                int[]left_pre=new int[i];
                System.arraycopy(pre,1,left_pre,0,i);
                int[]left_in=new int[i];
                System.arraycopy(in,0,left_in,0,i);
                //判断是否是构成正确前中序遍历。
                if (!isNumSame(left_pre,left_in))
                    return null;
                root.left=reConstructBinaryTree(left_pre,left_in);
                //右子树
                /*
                int[] right_pre=Arrays.copyOfRange(pre,i+1,pre.length);
                int[] right_in=Arrays.copyOfRange(in,i+1,in.length);
                 */
                int[] right_pre=new int[in.length-(i+1)];
                System.arraycopy(pre,i+1,right_pre,0,right_pre.length);
                int[] right_in=new int[in.length-(i+1)];
                System.arraycopy(in,i+1,right_in,0,right_in.length);
                //判断是否是构成正确前中序遍历。
                if (!isNumSame(right_pre,right_in))
                    return null;
                root.right=reConstructBinaryTree(right_pre,right_in);
            }
        }
        return root;
    }
    public boolean isNumSame(int[] left,int[] right){
        int[] left0=new int[left.length];
        System.arraycopy(left,0,left0,0,left.length);
        int[] right0=new int[right.length];
        System.arraycopy(right,0,right0,0,right.length);
        Arrays.sort(left0);
        Arrays.sort(right0);
        return Arrays.equals(left0,right0);

    }
}

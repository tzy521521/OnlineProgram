package JZ_Offer.ReConstructBinaryTree.Solution2;

import java.util.Arrays;

/**
 * Created by tzy on 2017/8/16.
 * 根据后序和中序遍历重建而二叉树
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] post, int [] in) {
        //递归终止条件~~~~
        if(post.length == 0||in.length == 0||post.length!=in.length){
            return null;
        }
        TreeNode root=new TreeNode(post[post.length-1]);
        for (int i=0;i<in.length;i++){
            if (in[i]==post[post.length-1]){
                //左子树
                /*
                int[] left_post= Arrays.copyOfRange(post,0,i);
                int[] left_in=Arrays.copyOfRange(in,0,i);
                 */
                int[]left_post=new int[i];
                System.arraycopy(post,0,left_post,0,i);
                int[]left_in=new int[i];
                System.arraycopy(in,0,left_in,0,i);
                //判断是否是构成正确前中序遍历。
                if (!isNumSame(left_post,left_in))
                    return null;
                root.left=reConstructBinaryTree(left_post,left_in);
                //右子树
                /*
                int[] right_post=Arrays.copyOfRange(post,i,post.length-1);
                int[] right_in=Arrays.copyOfRange(in,i+1,in.length);
                 */
                int[] right_post=new int[in.length-(i+1)];
                System.arraycopy(post,i,right_post,0,right_post.length);
                int[] right_in=new int[in.length-(i+1)];
                System.arraycopy(in,i+1,right_in,0,right_in.length);
                //判断是否是构成正确前中序遍历。
                if (!isNumSame(right_post,right_in))
                    return null;

                root.right=reConstructBinaryTree(right_post,right_in);
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

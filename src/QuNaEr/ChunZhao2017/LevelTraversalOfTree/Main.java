package QuNaEr.ChunZhao2017.LevelTraversalOfTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/8/31.
 * 给定一棵二叉树的前序（根、左、右）和中序（左、根、右）的打印结果，输出此二叉树按层（从左往右）打印结果。
 * 例如一棵二叉树前序：1 2 4 5 3；中序：4 2 5 1 3。可以构建出下图所示二叉树：
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] pre=new int[n];
            int[] in =new int[n];
            for (int i = 0; i <n ; i++) {
                pre[i]=scanner.nextInt();
            }
            for (int i = 0; i <n ; i++) {
                in[i]=scanner.nextInt();
            }
            TreeNode root=reConstructBinaryTree(pre,in);
            ArrayList<Integer> arrayList=printFromTopToBottom(root);
            for (Integer integer:arrayList) {
                System.out.println(integer);
            }
        }
    }
    //根据某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        //递归终止条件~~~~
        if(pre.length == 0||in.length == 0||pre.length!=in.length){
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);
        for (int i=0;i<in.length;i++){
            if (in[i]==pre[0]){
                //左子树前序遍历结果
                int[]left_pre=new int[i];
                System.arraycopy(pre,1,left_pre,0,i);
                //左子树中序遍历结果
                int[]left_in=new int[i];
                System.arraycopy(in,0,left_in,0,i);
                //判断是否是构成正确前中序遍历。
                if (!isNumSame(left_pre,left_in))
                    return null;

                root.left=reConstructBinaryTree(left_pre,left_in);

                //右子树前序遍历结果
                int[] right_pre=new int[in.length-(i+1)];
                System.arraycopy(pre,i+1,right_pre,0,right_pre.length);
                //右子树中序遍历结果
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
    //判断给定的二叉树的前序和中序（左、根、右）的打印结果是可以正常重建树
    private static boolean isNumSame(int[] left,int[] right){
        int[] left0=new int[left.length];
        System.arraycopy(left,0,left0,0,left.length);
        int[] right0=new int[right.length];
        System.arraycopy(right,0,right0,0,right.length);
        Arrays.sort(left0);
        Arrays.sort(right0);
        return Arrays.equals(left0,right0);

    }
    //树的层次遍历
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root){
        ArrayList<Integer> arrayList=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        if (root==null)
            return arrayList;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            arrayList.add(temp.val);
            if (temp.left!=null)
                queue.offer(temp.left);
            if (temp.right!=null)
                queue.offer(temp.right);
        }
        return arrayList;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}

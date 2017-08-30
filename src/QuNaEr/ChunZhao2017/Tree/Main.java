package QuNaEr.ChunZhao2017.Tree;

import java.util.*;

/**
 * Created by tzy on 2017/4/1.
 * 给定一棵二叉树的前序（根、左、右）和中序（左、根、右）的打印结果，输出此二叉树按层（从左往右）打印结果。
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    /**
     * 递归重建树。
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        //递归终止条件~~~~
        if(pre.length == 0||in.length == 0){
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);
        for (int i=0;i<in.length;i++){
            if (in[i]==pre[0]){
                //左子树
                int[] left_pre= Arrays.copyOfRange(pre,1,i+1);
                int[] left_in=Arrays.copyOfRange(in,0,i);
                root.left=reConstructBinaryTree(left_pre,left_in);
                //右子树
                int[] right_pre=Arrays.copyOfRange(pre,i+1,pre.length);
                int[] right_in=Arrays.copyOfRange(in,i+1,in.length);
                root.right=reConstructBinaryTree(right_pre,right_in);
            }
        }
        return root;
    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        ArrayList<Integer> arrayList=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode p=root;
        queue.offer(p);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if (temp!=null)
                arrayList.add(temp.val);
            else break;
            if (temp.left!=null)
                queue.offer(temp.left);
            if (temp.right!=null)
                queue.offer(temp.right);

        }
        return arrayList;
    }
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
            ArrayList<Integer> arrayList=new ArrayList<>();
            arrayList=PrintFromTopToBottom(root);
            for (int i = 0; i <arrayList.size() ; i++) {
                System.out.print(arrayList.get(i)+" ");
            }
        }
    }
}

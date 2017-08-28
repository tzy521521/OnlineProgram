package JZ_Offer.Serialize.Solution0;

import java.util.LinkedList;

/**
 * Created by tzy on 2017/8/20.
 */
public class Solution {
    //层次序列化
    public String Serialize(TreeNode root) {
        String string="{";
        if (root==null){
            string+="}";
            return string;
        }
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.offer(root);
        String string1 = string;
        string+=string1.valueOf(root.val)+",";
        while (!linkedList.isEmpty()){
            TreeNode temp=linkedList.poll();
            if (temp.left!=null){
                string+=String.valueOf(temp.left.val)+",";
                linkedList.offer(temp.left);
            }
            else
                string+="#,";

            if (temp.right!=null){
                string+=String.valueOf(temp.right.val)+",";
                linkedList.offer(temp.right);
            }
            else
                string+="#,";
        }
        int index=string.length()-1;
        while (index>=0){
            if (string.charAt(index)>='0'&&string.charAt(index)<='9')
                break;
            else
                index--;
        }
        string=string.substring(0,index+1);
        string+="}";
        return string;
    }
    //层次返序列化
    public TreeNode Deserialize(String str) {
        if (str==null)
            return null;
        String string = str.substring(1, str.length() - 1);
        String[] strings = string.split(",");
        if (strings[0].equals(""))
            return null;
        return Deserialize(strings);
    }
    public TreeNode Deserialize(String[] strs) {
        LinkedList<TreeNode> linkedList=new LinkedList();
        LinkedList<TreeNode> temp=new LinkedList<>();
        TreeNode flag=new TreeNode(-1);
        TreeNode root=null;

        for (String string: strs) {
            if (string.equals("#"))
                linkedList.offer(flag);
            else
                linkedList.offer(new TreeNode(Integer.valueOf(string)));
        }

        if (linkedList.size()>0){
            root=linkedList.poll();
            temp.offer(root);
        }

        while (linkedList.size()>0){
            TreeNode treeNode=temp.poll();
            if (linkedList.peek()!=flag){
                TreeNode treeNode1=linkedList.poll();
                treeNode.left=treeNode1;
                temp.offer(treeNode1);
            }
            else
                linkedList.poll();

            if (linkedList.peek()!=flag){
                TreeNode treeNode1=linkedList.poll();
                treeNode.right=treeNode1;
                temp.offer(treeNode1);
            }
            else
                linkedList.poll();
        }
        return root;
    }
}

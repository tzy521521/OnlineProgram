package JZ_Offer.KthNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tzy on 2017/8/14.
 */
public class Solution {
    public TreeNode KthNode(TreeNode pRoot, int k) {
        Stack<TreeNode> stack=new Stack<>();
        ArrayList<TreeNode> arrayList=new ArrayList<>();
        int flag=k;
        TreeNode temp=pRoot;
        while (temp!=null){
            stack.push(temp);
            temp=temp.left;
        }
        while (!stack.isEmpty()&&flag>0){
            TreeNode treeNode=stack.pop();
            arrayList.add(treeNode);
            flag--;
            treeNode=treeNode.right;
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode=treeNode.left;
            }
        }
        if (k<=arrayList.size()&&k>0)
            return arrayList.get(arrayList.size()-1);
        else
            return null;
    }
}

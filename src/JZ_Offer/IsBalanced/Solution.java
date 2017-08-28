package JZ_Offer.IsBalanced;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tzy on 2017/8/24.
 * AVL树（平衡二叉树特指平衡二叉查找树）
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        ArrayList<TreeNode> arrayList=new ArrayList<>();
        if (root==null)
            return true;
        /*
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            int balanceFactor=balanceFactor(temp);
            if (balanceFactor!=-1&&balanceFactor!=0&&balanceFactor!=1)
                return false;
            if (temp.left!=null)
                stack.push(temp.left);
            if (temp.right!=null)
                stack.push(temp.right);
        }
         */
        TreeNode temp=root;
        while (temp!=null){
            stack.push(temp);
            temp=temp.left;
        }
        while (!stack.isEmpty()){
            temp=stack.pop();
            int balanceFactor=balanceFactor(temp);
            if (balanceFactor!=-1&&balanceFactor!=0&&balanceFactor!=1)
                return false;
            arrayList.add(temp);
            if (arrayList.size()>0){
                if (temp.val<=arrayList.get(arrayList.size()-1).val)
                    return false;
            }
            temp=temp.right;
            while (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
        }
        return true;
    }
    //求树的高度的递归算法。
    public int deep(TreeNode node) {
        int h1, h2;
        if (node == null) {
            return 0;
        } else {
            h1 = deep(node.left);
            h2 = deep(node.right);
            return (h1 < h2) ? h2 + 1 : h1 + 1;
        }
    }
    //求某个节点的平衡因子
    public int balanceFactor(TreeNode node){
        return deep(node.right)-deep(node.left);
    }
}

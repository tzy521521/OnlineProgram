package JZ_Offer.Convert;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tzy on 2017/8/3.
 */
public class Solution {
    private ArrayList<TreeNode> arrayList=new ArrayList<>();
    //非递归中序遍历~
    private ArrayList<TreeNode> inOrder(TreeNode pRootOfTree) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=pRootOfTree;
        while (temp!=null){
            stack.push(temp);
            temp=temp.left;
        }
        while (!stack.isEmpty()){
            temp=stack.pop();
            arrayList.add(temp);
            temp=temp.right;
            while (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
        }
        return arrayList;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return null;
        else {
            inOrder(pRootOfTree);
            TreeNode root=arrayList.get(0);
            TreeNode temp1,temp2;
            temp1=root;
            for (int i =1 ; i <arrayList.size() ; i++) {
                temp2=arrayList.get(i);
                temp1.right=temp2;
                temp2.left=temp1;
                temp1=temp2;
            }
            return root;
        }
    }
}

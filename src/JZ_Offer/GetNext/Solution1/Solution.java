package JZ_Offer.GetNext.Solution1;

import java.util.Stack;

/**
 * Created by tzy on 2017/8/14.
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        Stack<TreeLinkNode> stack=new Stack<>();
        if (pNode==null)
            return null;
        TreeLinkNode temp=pNode;
        while (temp.next!=null){
                temp=temp.next;
        }
        while (temp!=null){
            stack.push(temp);
            temp=temp.left;
        }
        while (!stack.isEmpty()){
            TreeLinkNode treeNode=stack.pop();
            temp=treeNode;
            treeNode=treeNode.right;
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode=treeNode.left;
            }
            if (temp==pNode)
                break;
        }
        if (stack.isEmpty())
            return null;
        else
            return stack.peek();
    }
}

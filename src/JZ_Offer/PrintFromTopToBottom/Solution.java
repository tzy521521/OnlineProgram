package JZ_Offer.PrintFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tzy on 2017/3/31.
 * 就是简单的层次遍历
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
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
}

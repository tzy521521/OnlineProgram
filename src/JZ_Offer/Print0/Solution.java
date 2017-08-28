package JZ_Offer.Print0;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tzy on 2017/8/14.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
        LinkedList<TreeNode> queue1=new LinkedList();
        LinkedList<TreeNode> queue2=new LinkedList();
        if (pRoot!=null){
            queue1.add(pRoot);
            while (!queue1.isEmpty()||!queue2.isEmpty()){
                if (!queue1.isEmpty()){
                    ArrayList<Integer> arrayList=new ArrayList<>();
                    while (!queue1.isEmpty()){
                        TreeNode treeNode=queue1.poll();
                        if (treeNode.left!=null)
                            queue2.add(treeNode.left);
                        if (treeNode.right!=null)
                            queue2.add(treeNode.right);
                        arrayList.add(treeNode.val);
                    }
                    arrayLists.add(arrayList);
                }

                if (!queue2.isEmpty()){
                    ArrayList<Integer> arrayList=new ArrayList<>();
                    while (!queue2.isEmpty()){
                        TreeNode treeNode=queue2.poll();
                        if (treeNode.left!=null)
                            queue1.add(treeNode.left);
                        if (treeNode.right!=null)
                            queue1.add(treeNode.right);
                        arrayList.add(treeNode.val);
                    }
                    arrayList=reversed(arrayList);
                    arrayLists.add(arrayList);
                }
            }
        }
        return arrayLists;
    }
    public ArrayList<Integer> reversed(ArrayList<Integer>arrayList){
        ArrayList<Integer> result=new ArrayList<>();
        for (int i = arrayList.size()-1; i >=0 ; i--) {
            result.add(arrayList.get(i));
        }
        return result;
    }
}

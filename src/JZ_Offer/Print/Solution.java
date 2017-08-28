package JZ_Offer.Print;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tzy on 2017/8/22
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> queue1=new LinkedList<>();
        LinkedList<TreeNode> queue2=new LinkedList<>();
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
                    arrayLists.add(arrayList);
                }
            }
        }
        return arrayLists;
    }

    public ArrayList<Integer> max(TreeNode pRoot){
        Print(pRoot);
        ArrayList<Integer> list=new ArrayList<>();
        //最大的节点数
        int max=0;
        for (ArrayList<Integer> arrayList :arrayLists) {
            if (arrayList.size()>max)
                max=arrayList.size();
        }
        for (ArrayList<Integer> arrayList:arrayLists) {
            if (arrayList.size()==max)
                list=arrayList;
        }
        return list;
    }
}

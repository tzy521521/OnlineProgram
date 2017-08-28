package JZ_Offer.FindPath.Solution1;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/8/12.
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
       Path(listAll,list,root,target);
       return listAll;
    }
    public void Path(ArrayList<ArrayList<Integer>> listAll, ArrayList<Integer> list, TreeNode root, int target) {
        if(root == null)
            return ;
        list.add(root.val);
        target -= root.val;
        //到达叶子节点
        if(root.left == null && root.right == null){
            if (target==0)
                listAll.add(new ArrayList<>(list));
        }
        Path(listAll,list,root.left, target);
        Path(listAll,list,root.right, target);
        list.remove(list.size()-1);
        return ;
    }
}

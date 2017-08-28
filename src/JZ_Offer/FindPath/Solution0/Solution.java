package JZ_Offer.FindPath.Solution0;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tzy on 2017/8/13.
 * 根到任意节点,如果和满足target，输出这条路径。
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>>arrayLists=new ArrayList<>();
        Stack<TreeNode> sum=new Stack<>();
        Stack<TreeNode> temp=new Stack<>();
        int tatal=0;
        if (root==null||root.val>target)
            return arrayLists;
        temp.push(root);
        while (!temp.empty()){
            if (tatal+temp.peek().val==target){
                ArrayList<Integer> arrayList=new ArrayList<>();
                sum.push(temp.pop());
                tatal+=sum.peek().val;
                for (TreeNode t:sum) {
                    arrayList.add(t.val);
                }
                arrayLists.add(arrayList);

                tatal=prog(sum,temp,tatal);
            }else {
                sum.push(temp.pop());
                tatal+=sum.peek().val;
                if (sum.peek().left!=null){
                    temp.push(sum.peek().left);
                } else{
                    if (sum.peek().right!=null)
                        temp.push(sum.peek().right);
                    else{
                        tatal=prog(sum,temp,tatal);
                    }

                }

            }
        }
        return arrayLists;
    }
    private int prog(Stack<TreeNode> sum, Stack<TreeNode> temp, int tatal){
        tatal-=sum.peek().val;
        TreeNode flag=sum.pop();
        while (!sum.empty()){
            if (sum.peek().right!=null&&sum.peek().right!=flag){
                temp.push(sum.peek().right);
                break;
            }else {
                tatal-=sum.peek().val;
                flag=sum.pop();
            }
        }
        return tatal;
    }
}

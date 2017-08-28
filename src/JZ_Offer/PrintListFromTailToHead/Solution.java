package JZ_Offer.PrintListFromTailToHead;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tzy on 2017/3/30.
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> arrayList=new ArrayList<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}

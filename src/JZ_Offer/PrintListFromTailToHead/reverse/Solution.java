package JZ_Offer.PrintListFromTailToHead.reverse;

import java.util.Stack;


/**
 * Created by tzy on 2017/9/8.
 */
public class Solution {
    public ListNode printListFromTailToHead(ListNode root){
        Stack<ListNode> stack=new Stack<>();
        ListNode temp=root;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        ListNode frist=new ListNode(-1);
        temp=frist;
        while (!stack.isEmpty()){
            temp.next=stack.pop();
            temp=temp.next;
        }
        temp.next=null;
        return frist.next;
    }
}

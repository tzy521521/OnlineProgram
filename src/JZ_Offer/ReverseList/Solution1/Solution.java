package JZ_Offer.ReverseList.Solution1;

import java.util.Stack;

/**
 * Created by tzy on 2017/3/22.
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode temp=null;
        if (!stack.isEmpty()){
            temp=stack.pop();
            temp.next=null;
            head=temp;
        }
        while (!stack.isEmpty()){
            ListNode tp=stack.pop();
            temp.next=tp;
            tp.next=null;
            temp=tp;
        }
        return head;
    }
}

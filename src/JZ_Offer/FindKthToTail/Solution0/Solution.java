package JZ_Offer.FindKthToTail.Solution0;

import java.util.Stack;

/**
 * Created by tzy on 2017/3/29.
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k){
        Stack<ListNode> stack=new Stack<>();
        int flag=1;
        if (head==null||k==0)
            return null;
        ListNode temp=head;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        if (k<=stack.size()){
            while (flag<k){
                stack.pop();
                flag++;
            }
            return stack.pop();
        }
        else
            return null;
    }
}

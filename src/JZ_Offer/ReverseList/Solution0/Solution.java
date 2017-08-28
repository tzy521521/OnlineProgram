package JZ_Offer.ReverseList.Solution0;

/**
 * Created by tzy on 2017/3/22.
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head==null)
            return null;
        ListNode first=new ListNode(0);
        while (head!=null){
            ListNode temp=head;
            head=head.next;
            temp.next=first.next;
            first.next=temp;
        }
        return first.next;
    }
}

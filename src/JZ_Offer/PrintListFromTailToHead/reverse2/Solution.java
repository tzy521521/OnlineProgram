package JZ_Offer.PrintListFromTailToHead.reverse2;

/**
 * Created by tzy on 2017/9/8.
 */
public class Solution {
    public ListNode printListFromTailToHead(ListNode root){
        ListNode frist=new ListNode(-1);
        ListNode temp=root;
        while (temp!=null){
            root=temp.next;
            temp.next=frist.next;
            frist.next=temp;
            temp=root;
        }
        return frist.next;
    }
}

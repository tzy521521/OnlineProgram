package JZ_Offer.DeleteDuplication.Solution2;

/**
 * Created by tzy on 2017/8/20.
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null)
            return null;

        ListNode first=new ListNode(0);
        first.next=pHead;
        ListNode temp=first;
        ListNode current=pHead;
        while (current!=null&&current.next!=null){
            if (current.val==current.next.val){
                int val=current.val;
                while (current!=null&&current.val==val){
                    current=current.next;
                }
                temp.next=current;
            }else {
                temp=current;
                current=current.next;
            }
        }
        return first.next;
    }
}

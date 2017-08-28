package JZ_Offer.FindKthToTail.Solution1;

/**
 * Created by tzy on 2017/3/29.
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k){
        if (head==null)
            return null;
        ListNode p1=head;
        ListNode p2=head;
        int j=0;
        while (j<k){
            if (p2!=null){
                p2=p2.next;
                j++;
            }
            else
                break;
        }
        if (j<k)
            return null;
        while (p2!=null){
            p1= p1.next;
            p2=p2.next;
        }
        return p1;
    }
}

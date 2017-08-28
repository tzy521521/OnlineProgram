package JZ_Offer.DeleteDuplication.Solution1;

/**
 * Created by tzy on 2017/3/29.
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null) return null;
        ListNode n=new ListNode(0);
        n.next=pHead;
        pHead=n;
        ListNode pre=pHead;
            while (pre.next!=null){
                ListNode temp=pre.next;
                if (temp.next!=null){
                    ListNode current=temp.next;
                    int count1=1;
                    while (current!=null){
                        if (current.val==temp.val){
                            count1++;
                            current=current.next;
                            continue;
                        }
                        break;
                    }
                    if (count1>1) {
                        pre.next = current;
                    }else {
                        pre=temp;
                    }
                } else
                    break;
            }
            pHead=pHead.next;
            return pHead;
    }
}

package JZ_Offer.FindFirstCommonNode.Solution1;

/**
 * Created by tzy on 2017/8/3.
 * 如果链表pHead2中存在环，就会出现死循环。
 * 算法复杂度为O(n^2)
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1;ListNode p2=pHead2;
        while (p1!=null){
            if (p2==null)
                break;
            while (p2!=null){
                if (p2!=p1)
                    p2=p2.next;
                else
                    return p1;
            }
            p2=pHead2;
            p1=p1.next;
        }
        return null;
    }
}

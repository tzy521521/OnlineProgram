package JZ_Offer.Merge.Solution0;

/**
 * Created by tzy on 2017/3/24.
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1==null&&list2==null)
            return null;
        else if (list1==null)
            return list2;
        else if (list2==null)
            return list1;
        else {
            ListNode frist=new ListNode(0);
            ListNode p1,p2,p2_pre,p1_pre;
            if (list1.val>list2.val){
                frist.next=list2;
                p1=list2;p1_pre=p1;
                p2=list1;p2_pre=p2;
            } else {
                frist.next=list1;
                p1=list1;p1_pre=p1;
                p2=list2;p2_pre=p2;
            }
            while (p2!=null){
                while (p1!=null&&p1.val<=p2.val){
                    p1_pre=p1;
                    p1=p1.next;
                }
                p1_pre.next=p2;
                if (p1!=null){
                    while (p2!=null&&p2.val<=p1.val){
                        p2_pre=p2;
                        p2=p2.next;
                    }
                    p2_pre.next=p1;
                }
                else
                    break;
            }
            return frist.next;
        }
    }
}

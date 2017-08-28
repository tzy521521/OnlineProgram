package JZ_Offer.Merge.Solution1;

/**
 * Created by tzy on 2017/3/24.
 */
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode flag=list1;
        ListNode list1_pre=null;
            while (flag.next!=null){
                if (flag.val<=list2.val){
                    list1_pre=flag;
                    flag=flag.next;
                }
                list1_pre.next=list2;

                ListNode list2_pre=list2;
                while (list2.val<=flag.val){
                    list2_pre=list2;
                    list2=list2.next;
                }
                list2_pre.next=flag;
            }
        return list1;
    }
}

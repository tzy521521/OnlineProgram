package JZ_Offer.EntryNodeOfLoop;

import java.util.HashSet;

/**
 * Created by tzy on 2017/8/16.
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        HashSet<ListNode> hashSet=new HashSet<>();
        ListNode temp=pHead;
        while (temp!=null){
            for (ListNode node:hashSet) {
                if (node==temp)
                    return node;
            }
            hashSet.add(temp);
            temp=temp.next;
        }
        return null;
    }
}

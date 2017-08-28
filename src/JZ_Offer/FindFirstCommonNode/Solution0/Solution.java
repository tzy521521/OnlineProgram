package JZ_Offer.FindFirstCommonNode.Solution0;

import java.util.HashSet;

/**
 * Created by tzy on 2017/8/3.
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> hashSet=new HashSet<>();
        ListNode temp=pHead1;
        //将链表pHead1中所有的节点存在hashSet中;HashSet可以接受空值。不管链表中是否存在环。
        while (!hashSet.contains(temp)){
            if (temp!=null){
                hashSet.add(temp);
                temp=temp.next;
            }
            else
                break;
        }
        //若链表pHead2中的节点存在于hashSet中，则返回该节点。
       temp=pHead2;
        while (!hashSet.contains(temp)){
            if (temp!=null){
                temp=temp.next;
            }
            else
                break;
        }
        return temp;
    }
}

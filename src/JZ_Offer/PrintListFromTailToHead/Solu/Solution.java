package JZ_Offer.PrintListFromTailToHead.Solu;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/9/8.
 */
public class Solution {
    //头插法创建链表
    public ListNode creatList(ArrayList<Integer> arrayList){
        ListNode frist=new ListNode(-1);
        for (int i = arrayList.size()-1; i >=0 ; i--) {
            ListNode temp=new ListNode(arrayList.get(i));
            temp.next=frist.next;
            frist.next=temp;
        }
        return frist.next;
    }
    //头插法创建链表。
    public ListNode creatList0(ArrayList<Integer> arrayList){
        ListNode frist=new ListNode(-1);
        ListNode listNode=frist;
        for (int i = 0; i <arrayList.size() ; i++) {
            ListNode temp=new ListNode(arrayList.get(i));
            listNode.next=temp;
            listNode=temp;
        }
        return frist.next;
    }
}

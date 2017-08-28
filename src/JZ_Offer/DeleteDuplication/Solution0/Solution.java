package JZ_Offer.DeleteDuplication.Solution0;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tzy on 2017/8/20.
 * 利用链表的尾插法构建新的链表。(需要额外的一个节点)
 * 注意LinkedHashMap的遍历。
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null)
            return null;
        ListNode temp=pHead;
        LinkedHashMap<Integer,Integer> linkedHashMap=new LinkedHashMap<>();
        while (temp!=null){
            if (!linkedHashMap.containsKey(temp.val)){
                linkedHashMap.put(temp.val,1);
            }else {
                int num=linkedHashMap.get(temp.val);
                num++;
                linkedHashMap.put(temp.val,num);
            }
            temp=temp.next;
        }
        /*
        头插法。会改变顺序。
        pHead.next=null;
        Iterator<Map.Entry<Integer,Integer>> iter = linkedHashMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer,Integer> entry=iter.next();
            if (entry.getValue()==1){
                temp=new ListNode(entry.getKey());
                temp.next=pHead.next;
                pHead.next=temp;
            }
        }
         */
        pHead.next=null;
        temp=pHead;
        ListNode temp0;
        Iterator<Map.Entry<Integer,Integer>> iter = linkedHashMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer,Integer> entry=iter.next();
            if (entry.getValue()==1){
                temp0=new ListNode(entry.getKey());
                temp.next=temp0;
                temp=temp0;
            }
        }
        return pHead.next;
    }
}

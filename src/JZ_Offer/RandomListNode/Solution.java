package JZ_Offer.RandomListNode;

/**
 * Created by tzy on 2017/3/30.
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead==null)
            return null;
        RandomListNode temp=new RandomListNode(0);
        RandomListNode res=temp;
        RandomListNode current=pHead;
        while (current!=null){
            RandomListNode tp=new RandomListNode(current.label);
            temp.next=tp;
            temp=tp;
            temp.random=current.random;
            current=current.next;
        }
        res=res.next;
        return res;
    }
}

package JZ_Offer.FindKthToTail.Solution0;

/**
 * Created by tzy on 2017/8/27.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode listNode1=new ListNode(1);ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);ListNode listNode6=new ListNode(6);

        listNode1.next=listNode2;listNode2.next=listNode3;listNode3.next=listNode4;
        listNode4.next=listNode5;listNode5.next=listNode6;
        ListNode tem=solution.FindKthToTail( listNode1,7);
        if (tem!=null)
            System.out.println(tem.val);
    }
}

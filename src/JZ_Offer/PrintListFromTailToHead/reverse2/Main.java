package JZ_Offer.PrintListFromTailToHead.reverse2;

/**
 * Created by tzy on 2017/8/20.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        ListNode listNode1=new ListNode(2);ListNode listNode2=new ListNode(4);
        ListNode listNode3=new ListNode(6);ListNode listNode4=new ListNode(8);
        ListNode listNode5=new ListNode(10);ListNode listNode6=new ListNode(12);
        ListNode listNode7=new ListNode(14);
        listNode1.next=listNode2;listNode2.next=listNode3;listNode3.next=listNode4;
        listNode4.next=listNode5;listNode5.next=listNode6;listNode6.next=listNode7;

        ListNode root=solution.printListFromTailToHead(listNode1);
        System.out.println("~");
    }
}

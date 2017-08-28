package JZ_Offer.FindFirstCommonNode.Solution1;

/**
 * Created by tzy on 2017/8/3.
 */
public class Main {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1); ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3); ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);

        listNode1.next=listNode2;listNode2.next=listNode3;listNode3.next=listNode4;
        listNode5.next=listNode3;

        Solution solution=new Solution();
        ListNode res=solution.FindFirstCommonNode(listNode1,listNode5);
        System.out.println(res.val);
    }
}

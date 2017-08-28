package JZ_Offer.ReverseList.Solution1;

/**
 * Created by tzy on 2017/8/27.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode listNode1=new ListNode(1);ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);ListNode listNode6=new ListNode(6);
        ListNode list=listNode1;
        listNode1.next=listNode2;listNode2.next=listNode3;listNode3.next=listNode4;
        listNode4.next=listNode5;listNode5.next=listNode6;
        ListNode temp=solution.ReverseList(list);
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println("输出结束~");
    }
}

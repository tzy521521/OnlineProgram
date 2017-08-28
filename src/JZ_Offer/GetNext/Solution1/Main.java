package JZ_Offer.GetNext.Solution1;

/**
 * Created by tzy on 2017/8/14.
 */
public class Main {
    public static void main(String[] args) {
        TreeLinkNode treeLinkNode1=new TreeLinkNode(8);TreeLinkNode treeLinkNode2=new TreeLinkNode(6);
        TreeLinkNode treeLinkNode3=new TreeLinkNode(10);TreeLinkNode treeLinkNode4=new TreeLinkNode(5);
        TreeLinkNode treeLinkNode5=new TreeLinkNode(7);TreeLinkNode treeLinkNode6=new TreeLinkNode(9);
        TreeLinkNode treeLinkNode7=new TreeLinkNode(11);

        treeLinkNode1.left=treeLinkNode2;treeLinkNode1.right=treeLinkNode3;
        treeLinkNode2.next=treeLinkNode1;treeLinkNode3.next=treeLinkNode1;

        treeLinkNode2.left=treeLinkNode4;treeLinkNode2.right=treeLinkNode5;
        treeLinkNode4.next=treeLinkNode2;treeLinkNode5.next=treeLinkNode2;

        treeLinkNode3.left=treeLinkNode6;treeLinkNode3.right=treeLinkNode7;
        treeLinkNode6.next=treeLinkNode3;treeLinkNode7.next=treeLinkNode3;


        Solution solution=new Solution();
        TreeLinkNode treeLinkNode=solution.GetNext(treeLinkNode3);
        System.out.println(treeLinkNode.val);
    }
}

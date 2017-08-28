package JZ_Offer.GetNext.Solution0;

/**
 * Created by tzy on 2017/8/14.
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //二叉树为空，则返回空；
        if (pNode==null)
            return null;
        //如果节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
        if (pNode.right!=null){
            pNode=pNode.right;
            while (pNode.left!=null)
                pNode=pNode.left;
            return pNode;
        }
        //该节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点，重复之前的判断，返回结果。
        while (pNode.next!=null){
            if (pNode==pNode.next.left)
                return pNode.next;
            else
                pNode=pNode.next;
        }
        //该节点为根节点且没有右孩子。
        return null;
    }
}

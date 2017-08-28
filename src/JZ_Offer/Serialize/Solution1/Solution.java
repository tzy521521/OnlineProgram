package JZ_Offer.Serialize.Solution1;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/8/15.
 * 先序序列化。
 */
public class Solution {
    public String Serialize(TreeNode root) {
        ArrayList<String> arrayList = new ArrayList<>();
        String string = "{";
        if (root==null){
            string+="}";
            return string;
        }
        Serialize(arrayList, root);

        for (String s : arrayList) {
            string += s + ",";
        }
        int index=string.length()-1;
        while (index>=0){
            if (string.charAt(index)>='0'&&string.charAt(index)<='9')
                break;
            else
                index--;
        }
        string=string.substring(0,index+1);
        string+="}";
        return string;
    }

    private void Serialize(ArrayList<String> arrayList, TreeNode root) {
        if (root == null) {
            arrayList.add("#");
            return;
        } else {
            arrayList.add(String.valueOf(root.val));
            Serialize(arrayList, root.left);
            Serialize(arrayList, root.right);
        }
    }
    public String Serialize1(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize1(root.left));
        sb.append(Serialize1(root.right));
        return sb.toString();
    }

    public int index = -1;
    public TreeNode Deserialize(String str) {
        String string = str.substring(1, str.length() - 1);
        String[] strings = string.split(",");
        if (strings[0].equals(""))
            return null;
        return Deserialize(strings);
    }

    public TreeNode Deserialize(String[] strs) {
        index++;
        TreeNode root = null;
        if (index<strs.length&&!strs[index].equals("#")){
            root=new TreeNode(Integer.valueOf(strs[index]));
            root.left=Deserialize(strs);
            root.right=Deserialize(strs);
        }
        return root;
    }
}


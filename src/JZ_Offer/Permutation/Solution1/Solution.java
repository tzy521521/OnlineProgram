package JZ_Offer.Permutation.Solution1;

import java.util.*;

/**
 * Created by tzy on 2017/5/14.
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        String string=new String(chars);
        ArrayList<String> result=new ArrayList<>();
        LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>();
        Stack<String[]> stack=new Stack<>();
        stack.push(new String[]{string,""});
        do {
            String[] temp=stack.pop();
            String resStr=temp[1];
            String temStr=temp[0];
            for (int i=temStr.length()-1;i>=0;i--){
                String[] strs=new String[]{temStr.substring(0,i)+temStr.substring(i+1),resStr+temStr.substring(i,i+1)};
                if (strs[0].length()==0)
                    linkedHashSet.add(strs[1]);
                else
                    stack.push(strs);
            }
        }while (!stack.isEmpty());
        result.addAll(linkedHashSet);
        return result;
    }
}

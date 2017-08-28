package JZ_Offer.Permutation.Solution0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by tzy on 2017/5/14.
 */
public class Solution {
    public ArrayList<String> Permutation(String str){
        ArrayList<String> result=new ArrayList<>();
        HashSet<String> hashSet=new HashSet<>();
        Stack<String[]> stack=new Stack<>();
        stack.push(new String[]{str,""});
        do {
            String[] temp=stack.pop();
            String resStr=temp[1];
            String temStr=temp[0];
            for (int i=temStr.length()-1;i>=0;i--){
                String[] strs=new String[]{temStr.substring(0,i)+temStr.substring(i+1),resStr+temStr.substring(i,i+1)};
                if (strs[0].length()==0)
                    hashSet.add(strs[1]);
                else
                    stack.push(strs);
            }
        }while (!stack.isEmpty());
        return (ArrayList<String>) hashSet.parallelStream().sorted().collect(Collectors.toList());
    }
}

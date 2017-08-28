package JZ_Offer.IsPopOrder;

import java.util.Stack;

/**
 * Created by tzy on 2017/3/31.
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA){
        if(pushA==null||popA==null||pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> stack=new Stack<>();
        int flag=0;
        for (int i = 0; i <pushA.length ; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[flag]){
                stack.pop();
                flag++;
            }
        }
        return stack.empty();
    }
}

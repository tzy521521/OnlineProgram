package JZ_Offer.FindContinuousSequence;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tzy on 2017/8/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
        LinkedList<Integer> deque=new LinkedList<>();
        int small=1;int big=2;int end=(sum+1)/2;
        deque.offer(small);deque.offer(big);
        int total=small+big;
        while (small<big&&big<=end){
            if (total==sum){
                ArrayList<Integer> arrayList=new ArrayList<>(deque);
                arrayLists.add(arrayList);
                total-=small;
                small++;
                deque.poll();
            }else if (total>sum){
                total-=small;
                small++;
                deque.poll();
            }else {
                big++;
                deque.offer(big);
                total+=big;
            }
        }
        return arrayLists;
    }
}

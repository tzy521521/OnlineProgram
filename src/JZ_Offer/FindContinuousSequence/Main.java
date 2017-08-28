package JZ_Offer.FindContinuousSequence;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/8/16.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        ArrayList<ArrayList<Integer>>arrayLists=solution.FindContinuousSequence(9);
        for (ArrayList<Integer>arrayList:arrayLists) {
            System.out.println(arrayList);
        }
    }
}

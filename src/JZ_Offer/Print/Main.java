package JZ_Offer.Print;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/8/14.
 */
public class Main {
    public static void main(String[] args) {
        int[] elem={8,6,10,5,7,9,11};

        BT bt=new BT(elem);
        Solution solution=new Solution();
        ArrayList<ArrayList<Integer>> arrayLists=solution.Print(bt.root);
        for (ArrayList<Integer>arrayList:arrayLists) {
            System.out.println(arrayList);
        }
        ArrayList<Integer> arrayList=solution.max(bt.root);
        System.out.println(arrayList);
    }
}

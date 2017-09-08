package JZ_Offer.PrintListFromTailToHead.Solu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tzy on 2017/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        ListNode root=solution.creatList(arrayList);
        System.out.println(root.val);

        ListNode root0=solution.creatList0(arrayList);
        System.out.println(root0.val);
    }
}

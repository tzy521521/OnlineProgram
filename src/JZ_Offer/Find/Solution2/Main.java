package JZ_Offer.Find.Solution2;

import JZ_Offer.Find.Solution0.Solution;

/**
 * Created by tzy on 2017/8/20.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[][]array={{3,7,6,9},{5,8,9,10},{7,9,11,12}};
        int target=11;
        System.out.println(solution.Find(target,array));

    }
}

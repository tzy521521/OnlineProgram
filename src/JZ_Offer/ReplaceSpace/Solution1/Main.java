package JZ_Offer.ReplaceSpace.Solution1;

import JZ_Offer.ReplaceSpace.Solution0.Solution;

/**
 * Created by tzy on 2017/8/20.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        StringBuffer stringBuffer=new StringBuffer("We  Are Happy");

        System.out.println(solution.replaceSpace(stringBuffer));
    }
}

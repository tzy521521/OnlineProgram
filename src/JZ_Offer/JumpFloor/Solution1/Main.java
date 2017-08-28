package JZ_Offer.JumpFloor.Solution1;

import JZ_Offer.JumpFloor.Solution0.Solution;

/**
 * Created by tzy on 2017/8/20.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        Long stat=System.currentTimeMillis();
        System.out.println(solution.JumpFloor(-1));
        Long time=(System.currentTimeMillis()-stat);
        System.out.println("Times "+time+" ns");
        System.out.println("Times "+time/1_000_000+" ms");
    }
}

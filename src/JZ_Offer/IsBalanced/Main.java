package JZ_Offer.IsBalanced;

/**
 * Created by tzy on 2017/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] elem={1,2,3,4,5,6,7};
        BT bt=new BT(elem);

        System.out.println(solution.deep(bt.root));
        System.out.println(solution.IsBalanced_Solution(bt.root));
        System.out.println(solution.balanceFactor(bt.root));
    }
}

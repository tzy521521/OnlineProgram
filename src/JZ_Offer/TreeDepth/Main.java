package JZ_Offer.TreeDepth;

/**
 * Created by tzy on 2017/8/24.
 */
public class Main {
    public static void main(String[] args) {
        int[] elem={8,6,10,5,7,9,11};
        BT bt=new BT(elem);
        Solution solution=new Solution();
        System.out.println(solution.TreeDepth(bt.root));
    }
}

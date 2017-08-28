package JZ_Offer.IsSymmetrical;

/**
 * Created by tzy on 2017/8/14.
 */
public class Main {
    public static void main(String[] args) {
        int[] elem={5,5,5,5,0,5,5,5,0};

        BT bt=new BT(elem);
        Solution solution=new Solution();
        System.out.println(solution.isSymmetrical(bt.root));
    }
}

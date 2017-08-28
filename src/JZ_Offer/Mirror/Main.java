package JZ_Offer.Mirror;

/**
 * Created by tzy on 2017/8/20.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] elem={1,2,3,4,5,6,7};
        BT bt=new BT(elem);
        solution.Mirror(bt.root);
        System.out.println(bt.root);
    }
}

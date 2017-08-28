package JZ_Offer.IsPopOrder;

/**
 * Created by tzy on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] push={1,2,3,4,5};
        int[] pop={4,3,5,1,2};
        System.out.println(solution.IsPopOrder(push,pop));
    }
}

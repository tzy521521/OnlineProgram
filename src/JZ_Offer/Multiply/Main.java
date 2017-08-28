package JZ_Offer.Multiply;

import java.util.Arrays;

/**
 * Created by tzy on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] A={4,5,7,3,6,1};
        int[] B=solution.multiply(A);
        System.out.println(Arrays.toString(B));
    }
}

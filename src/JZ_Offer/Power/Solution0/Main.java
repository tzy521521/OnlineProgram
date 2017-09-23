package JZ_Offer.Power.Solution0;

import java.math.BigDecimal;

/**
 * Created by tzy on 2017/8/26.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.Power(95.123,12));
        double d=solution.Power(95.123,12);
        BigDecimal bigDecimal=new BigDecimal(d);
        System.out.println(bigDecimal);
    }
}

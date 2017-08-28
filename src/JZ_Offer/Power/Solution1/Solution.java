package JZ_Offer.Power.Solution1;

/**
 * Created by tzy on 2017/8/26.
 * 快速幂算法,其时间复杂度为 O(log₂N)。
 */
public class Solution {
    public double Power(double base, int exponent) {
        double rslt = 1.0;
        int n=Math.abs(exponent);
        while (n!=0)
        {
            //如果exponent为奇数
            if ((n&1)==1)
                rslt *= base;
            base *= base;
            //exponent/2
            n>>=1;
        }
        if (exponent == 0)
            return 1;
        else if (exponent>0)
            return rslt;
        else
            return 1.0/rslt;
    }
}

package JZ_Offer.NumberOf1.Solution0;

/**
 * Created by tzy on 2017/3/22.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
    public int NumberOf1(int n) {
        return Integer.toBinaryString(n).replaceAll("0","").length();
    }
}

package JZ_Offer.NumberOf1.Solution2;

/**
 * Created by tzy on 2017/3/22.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
    public int NumberOf1(int n) {
        //求x的二进制表达式有多少个1
        int count=0;
        while (n!=0){
            count++;
            n&=(n-1);
        }
        return count;
    }
    public int NumberOf0(int n) {
        //求x的二进制表达式有多少个0
        int count=0;
        while ((n+1)!=0){
            count++;
            n|=(n+1);
        }
        return count;
    }
}

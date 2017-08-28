package JZ_Offer.NumberOf1Between1AndN.Solution1;

/**
 * Created by tzy on 2017/8/12.
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int num=0;
        for (int i = 1; i <=n ; i++) {
            String s=String.valueOf(i);
            for (int j = 0; j <s.length() ; j++) {
                if (s.charAt(j)=='1')
                    num++;
            }
        }
        return num;
    }
}

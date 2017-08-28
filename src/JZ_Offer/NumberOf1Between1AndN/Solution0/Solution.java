package JZ_Offer.NumberOf1Between1AndN.Solution0;

import java.util.Arrays;

/**
 * Created by tzy on 2017/8/12.
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n<1)
            return 0;
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 1; i <=n ; i++) {
            stringBuffer.append(i);
        }
        char[] number=stringBuffer.toString().toCharArray();
        Arrays.sort(number);
        String string=String.valueOf(number);
        return string.lastIndexOf('1')-string.indexOf('1')+1;
    }
}

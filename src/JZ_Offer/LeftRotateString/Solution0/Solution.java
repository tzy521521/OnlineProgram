package JZ_Offer.LeftRotateString.Solution0;

/**
 * Created by tzy on 2017/3/23.
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str==null||str.length()==0)
            return "";
        else
            return str.substring(n%str.length())+String.copyValueOf(str.toCharArray(),0,n%str.length());
    }
}

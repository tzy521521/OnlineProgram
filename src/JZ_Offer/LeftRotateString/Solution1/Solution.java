package JZ_Offer.LeftRotateString.Solution1;

/**
 * Created by tzy on 2017/3/30.
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str==null||str.length()==0)
            return "";
        else
            return str.substring(n%str.length())+str.substring(0,n%str.length());
    }
}

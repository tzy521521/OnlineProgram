package JZ_Offer.IsNumeric;

/**
 * Created by tzy on 2017/3/23.
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        try {
            Double.parseDouble(new String(str));
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}

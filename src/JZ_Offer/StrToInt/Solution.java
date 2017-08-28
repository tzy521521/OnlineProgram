package JZ_Offer.StrToInt;

/**
 * Created by tzy on 2017/8/18.
 */
public class Solution {
    public int StrToInt(String str) {
        if (str==null||str.length()<1)
            return 0;
        int sum=0;
        if (str.charAt(0)=='+'||str.charAt(0)=='-'||str.charAt(0)>='0'&&str.charAt(0)<='9'){
            for (int i = str.length()-1; i >0 ; i--) {
                if (!isNumber(str.charAt(i)))
                    return 0;
                else {
                    double temp=Math.pow(10,str.length()-1-i);
                    sum+=(str.charAt(i)-48)*(int)temp;
                }
            }
            if (str.charAt(0)=='+')
                sum=sum*1;
            else if (str.charAt(0)=='-')
                sum=sum*-1;
            else{
                double temp=Math.pow(10,str.length()-1);
                sum+=(str.charAt(0)-48)*temp;
            }
            return sum;
        }else
            return 0;
    }
    public boolean isNumber(char c){
        if (c>='0'&&c<='9')
            return true;
        else
            return false;
    }
}

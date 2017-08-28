package JZ_Offer.ReverseSentence;

/**
 * Created by tzy on 2017/3/29.
 */
public class Solution {
    public String ReverseSentence(String str){
        StringBuffer temp=new StringBuffer();
        if(str.trim().equals(""))
            return str;
        else {
            String[] strings=str.split("\\s+");
            for (int i=strings.length-1;i>0;i--) {
                temp.append(strings[i]);
                temp.append(" ");
            }
            temp.append(strings[0]);
        }
        return temp.toString();
    }
}

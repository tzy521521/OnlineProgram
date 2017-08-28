package JZ_Offer.ReplaceSpace.Solution1;

/**
 * Created by tzy on 2017/3/21.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。(多个空格替换多个)
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                stringBuffer.append("%20");
            }
            else
                stringBuffer.append(str.charAt(i));
        }
        return stringBuffer.toString();
    }
}

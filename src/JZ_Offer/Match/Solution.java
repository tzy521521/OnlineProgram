package JZ_Offer.Match;

/**
 * Created by tzy on 2017/8/18.
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if(str==null||pattern==null)
            return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }
    private boolean matchCore(char[] str,int strIndex, char[] pattern,int patternIndex){
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)){
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//字符串后移动1个，模式后移2。视为x*模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                //如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }else {
            //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            }
            else
                return false;
        }
    }
}

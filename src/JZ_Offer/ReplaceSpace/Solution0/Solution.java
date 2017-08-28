package JZ_Offer.ReplaceSpace.Solution0;

/**
 * Created by tzy on 2017/3/21.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。(多个空格替换多个)
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        /**
         * \s匹配任意空白字符
         * \S匹配任意不是空白的字符
         */
        return str.toString().replaceAll("\\s","%20");
    }
}

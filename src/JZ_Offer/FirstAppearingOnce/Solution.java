package JZ_Offer.FirstAppearingOnce;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tzy on 2017/8/16.
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution {
    private LinkedHashMap<Character,Integer> linkedHashMap=new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (linkedHashMap.containsKey(ch)){
            int val=linkedHashMap.get(ch);
            val++;
            linkedHashMap.put(ch,val);
        }else
            linkedHashMap.put(ch,1);
        //java8中的API
        //linkedHashMap.put(ch,linkedHashMap.getOrDefault(ch,0)+1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character,Integer> entry:linkedHashMap.entrySet()) {
            if (entry.getValue()==1)
                return entry.getKey();
        }
        return '#';
    }
}

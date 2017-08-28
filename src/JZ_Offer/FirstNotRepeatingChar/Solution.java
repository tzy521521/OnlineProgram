package JZ_Offer.FirstNotRepeatingChar;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Created by tzy on 2017/3/31.
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str==null||str.length()<1)
            return -1;
        else if (str.length()==1)
            return 0;
        else {
            LinkedHashMap<Character,Integer> linkedHashMap=new LinkedHashMap<>();
            for (int i = 0; i <str.length(); i++) {
                if (!linkedHashMap.containsKey(str.charAt(i))){
                    linkedHashMap.put(str.charAt(i),1);
                }
                else {
                    int val=linkedHashMap.get(str.charAt(i));
                    val++;
                    linkedHashMap.put(str.charAt(i),val);
                }
                //linkedHashMap.getOrDefault()java8的API
                //linkedHashMap.put(str.charAt(i),linkedHashMap.getOrDefault(str.charAt(i),0)+1);
            }
            for (Map.Entry<Character,Integer> entry:linkedHashMap.entrySet()) {
                if (entry.getValue()==1){
                    return str.indexOf(entry.getKey());
                }
            }
        }
        return -1;
    }
}

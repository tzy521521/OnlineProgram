package QuNaEr.FirstRepeat;

import java.util.HashMap;

/**
 * Created by tzy on 2017/4/1.
 */
public class FirstRepeat {
    public char findFirstRepeat(String A){
        HashMap<Character,Integer> hashMap=new HashMap();
        char res=' ';
        for (int i = 0; i <A.length() ; i++) {
            res=A.charAt(i);
            if (hashMap.containsKey(res))
                break;
            else
                hashMap.put(res,1);
        }
        return res;
    }
}

package HuaWei.LCS0;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/8/12.
 */
public class Main {
    public static void main(String[] args) {
        String a = "ABABDAB";
        String b = "BADBABA";

        System.out.println(MyLCS0.length_LCS(a,b));
        ArrayList<String> arrayList= MyLCS0.sequence_LCS(a,b);
        for (String s:arrayList) {
            System.out.println(s);
        }
    }
}

package iQIYI.Selection;

import java.net.URLDecoder;

/**
 * Created by tzy on 2017/10/8.
 */
public class Test2 {
    public static void main(String[] args)throws Exception {
        String string="https://www.nowcoder.com/search?query=java";
        String s="s";
        URLDecoder.decode(string,s);
        System.out.println(s);
    }
}

package iQIYI.Selection;

/**
 * Created by tzy on 2017/10/7.
 */
public class Demo {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("Hello");
        StringBuffer b = new StringBuffer("World");
        operator(a, b);
        System.out.println(a + "," + b);
    }
    public static void operator(StringBuffer strbufa, StringBuffer strbufb) {
        strbufa.append(strbufb);
        strbufb = strbufa;
    }
}

package XiaoMi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class te {
    public static void main(String[] args) {
        String string="ADD.sdfFFFvvfFvfvFFFvvf";
        String regex="[A-Z][a-z]";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(string);
        if (matcher.find())
            System.out.println(matcher.start());
        /*
        while (matcher.find()){
            System.out.println(matcher.start());
        }
         */

        System.out.println("!!!");
    }
}

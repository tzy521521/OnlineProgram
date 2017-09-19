package XiaoMi.NameTranslation.Solution1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tzy on 2017/9/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            System.out.println(nameTrance(string));
        }
    }
    private static String nameTrance(String string){
        StringBuilder stringBuilder=new StringBuilder(string.replaceAll("\\.","_"));
        Pattern pattern=Pattern.compile("[A-Z][a-z]");
        int index=0;
        while (true){
            Matcher matcher=pattern.matcher(stringBuilder.substring(index));
            if(matcher.find()){
                int temp=matcher.start();
                stringBuilder.insert(index+temp,"_");
                index=index+temp+2;
            }else
                break;
        }

        index=0;
        Pattern pattern1=Pattern.compile("(([a-z][A-Z])|([a-zA-Z]\\d)|(\\d[a-zA-Z]))");
        while (true){
            Matcher matcher=pattern1.matcher(stringBuilder.substring(index));
            if(matcher.find()){
                int temp=matcher.start()+1;
                stringBuilder.insert(index+temp,"_");
                index=index+temp+2;
            }else
                break;
        }
        String result=stringBuilder.toString().toUpperCase();
        result="_"+result+"_";
        return result;
    }
}

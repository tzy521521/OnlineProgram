package XiaoMi.NameTranslation.Solution0;

import java.util.Scanner;

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
        StringBuilder stringBuilder=new StringBuilder(string);
        stringBuilder.append('_');
        for (int i = 0; i <stringBuilder.length()-1 ; i++) {//找2个长度的字符串
            //大写小写，大写之前插入 _
            if (isUpCase(stringBuilder.charAt(i))&&isLowCase(stringBuilder.charAt(i+1))){
                stringBuilder.insert(i,"_");
                i+=2;
            }
            //小写大写，小写之后插入 _
            if (isLowCase(stringBuilder.charAt(i))&&isUpCase(stringBuilder.charAt(i+1))){
                stringBuilder.insert(i+1,"_");
                i+=2;
            }
            //数字字母，数字后插入 _
            if (isNum(stringBuilder.charAt(i))&&isChar(stringBuilder.charAt(i+1))){
                stringBuilder.insert(i+1,"_");
                i+=2;
            }
            //字母数字，字母后 插入 _
            if (isChar(stringBuilder.charAt(i))&&isNum(stringBuilder.charAt(i+1))){
                stringBuilder.insert(i+1,"_");
                i+=2;
            }
            //将.变为 _
            if (isPoint(stringBuilder.charAt(i))&&isNumOrChar(stringBuilder.charAt(i+1))){
                stringBuilder.setCharAt(i,'_');
                i+=1;
            }
            if (isNumOrChar(stringBuilder.charAt(i))&&isPoint(stringBuilder.charAt(i+1))){
                stringBuilder.setCharAt(i+1,'_');
                i+=2;
            }
        }
        if (stringBuilder.charAt(0)!='_')
            stringBuilder.insert(0,'_');
        return stringBuilder.toString().toUpperCase();
    }

    //是否是小写字幕
    private static boolean isLowCase(char c){
        return ((c+"").matches("[A-Z]"));
    }
    //是否是大写字母
    private static boolean isUpCase(char c){
        return ((c+"").matches("[a-z]"));
    }
    //是否是字母
    private static boolean isChar(char c){
        return ((c+"").matches("[a-zA-Z]"));
    }
    //是否是数字
    private static boolean isNum(char c){
        return ((c+"").matches("\\d"));
    }
    //是否是.
    private static boolean isPoint(char c){
        return ((c+"").matches("\\."));
    }
    //是否是字母和数字
    private static boolean isNumOrChar(char c){
        return ((c+"").matches("[0-9a-zA-Z]"));
    }
}

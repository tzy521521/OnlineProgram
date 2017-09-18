package WangYi.Qiuzhao2017;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/18.
 * //暴力法
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.next();

        }
    }
    private static void getSequence(String string){
        HashSet<String> hashSet=new HashSet<>();
        for (int i = 0; i <string.length() ; i++) {
            char c=string.charAt(i);
            StringBuilder stringBuilder=new StringBuilder(string);
            stringBuilder.deleteCharAt(i);
            for (int j = 0; j <string.length() ; j++) {
                stringBuilder.insert(j,c);
                if (isLegal(stringBuilder.toString()))
                    hashSet.add(stringBuilder.toString());
                stringBuilder.deleteCharAt(j);
            }
        }
    }
    //判断是否是一个合法的括号序列。
    private static boolean isLegal(String string){

        return true;
    }
}

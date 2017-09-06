package Letv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/6.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<String[]> arrayList=new ArrayList<>();
        while (scanner.hasNext()){
            String string=scanner.next();
            String result=scanner.next();
            String min=minInteger(string);
            if (min.equals(result))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static String minInteger(String string){
        char[] chars=string.toCharArray();
        Arrays.sort(chars);
        int index=0;
        while (index<chars.length){
            if (chars[index]!='0')
                break;
            index++;
        }
        if (index<chars.length){
            char c=chars[index];
            chars[index]=chars[0];
            chars[0]=c;
        }
        return new String(chars);
    }
}

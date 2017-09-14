package ofo;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/14.
 */
public class Main {
    static int reverse(String s) {
        String string="";
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = s.length()-1; i >0 ; i--) {
            stringBuilder.append(s.charAt(i));
        }
        if (s.charAt(0)>='0'&&s.charAt(0)<='9'){
            stringBuilder.append(s.charAt(0));
            string=stringBuilder.toString();
        }
        else{
            string="-"+stringBuilder.toString();
        }
        try {
            return Integer.valueOf(string);
        }catch (Exception e){
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string=in.nextLine().trim();
        System.out.println(reverse(string));
    }
}

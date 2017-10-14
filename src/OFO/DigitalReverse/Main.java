package OFO.DigitalReverse;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/14.
 * 数字逆序输出结果，如果逆序后的结果不在int类型的数据范围内输出0;
 * -123输出-321
 */
public class Main {
    private static int reverse(String s) {
        String string;
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
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.next();
            System.out.println(reverse(string));
        }
    }
}

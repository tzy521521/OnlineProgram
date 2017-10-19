package u51.MultiplyStrings;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/18.
 * leetcode上是整数，确定一下小数点的位置就行。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String numl=scanner.next();
            String num2=scanner.next();
            System.out.println(multiply(numl,num2));
        }
    }
    private static String multiply(String num1, String num2) {
        //每个数的小数点后有几位。
        int dian_leng=0;
        int dian_1=num1.indexOf('.');
        int dian_2=num2.indexOf('.');
        if (dian_1>0)
            dian_leng+=num1.length()-1-dian_1;
        if (dian_2>0)
            dian_leng+=num2.length()-1-dian_2;
        num1=num1.replace(".","");
        num2=num2.replace(".","");

        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int index = len1 + len2 - i - j - 2;
                product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product[index + 1] += product[index] / 10;
                product[index] %= 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = product.length - 1; i >= 0; i--) {
            if (stringBuilder.length() == 0 && product[i] == 0)
                continue;
            stringBuilder.append(product[i]);
        }

        //确定小数点位置。
        if (stringBuilder.length()<=dian_leng){
            StringBuilder temp=new StringBuilder("0.");
            for (int i = 0; i <dian_leng-stringBuilder.length() ; i++) {
                temp.append(0);
            }
            stringBuilder.insert(0,temp);
        }
        else
            stringBuilder.insert(stringBuilder.length()-dian_leng,".");
        return stringBuilder.toString();
    }
}
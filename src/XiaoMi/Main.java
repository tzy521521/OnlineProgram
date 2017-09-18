package XiaoMi;

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
        String temp=string.replaceAll("\\.","_");

        StringBuilder stringBuilder=new StringBuilder(temp);

        String[] arry=temp.split("\\D+");
        for (String str:arry) {
            if (str.length()>1){
                int index=stringBuilder.toString().indexOf(str);
                if (index-1>=0&&stringBuilder.toString().charAt(index-1)!='_')
                    stringBuilder.insert(index,"_");
            }
        }

        String[] arry2=temp.replaceAll("\\d+","").replaceAll("[A-Z][a-z]+","_").replaceAll("[a-z]+","_").split("_");

        for (String str:arry2) {
            int index=stringBuilder.toString().indexOf(str);
            if (index-1>=0&&stringBuilder.toString().charAt(index-1)!='_')
                stringBuilder.insert(index,"_");
        }
        int i=0;
        /*
        String temp=string.replaceAll("\\.","_");

        String temp1=string.replaceAll("\\d+",".");
        temp1=temp1.replaceAll("[A-Z][a-z]+",".");
        String[] arry1=temp1.split("\\.");//全大写
         */
        /*
        String temp2=string.replaceAll("\\d+",".");
        temp2=temp2.replaceAll("[A-Z]+",".");
        String[] arry2=temp2.split("\\.");//全小写和一个写加一个小写

        String[] arry3=string.split("\\D+");

        for (String str:arry1) {
            int index=string.indexOf(str);
            stringBuilder.insert(index,"_");
        }

        for (String str:arry2) {
            int index=string.indexOf(str);
            stringBuilder.insert(index,"_");
        }
        for (String str:arry3) {
            int index=string.indexOf(str);
            stringBuilder.insert(index,"_");
        }
         */

        String result=stringBuilder.toString();
        result="_"+result+"_";
        result=result.toUpperCase();
        return result;
    }
}

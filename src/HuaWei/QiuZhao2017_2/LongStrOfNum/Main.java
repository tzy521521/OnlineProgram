package HuaWei.QiuZhao2017_2.LongStrOfNum;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/6.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            if (string==null||string.length()<1){
                System.out.println(""+","+0);
            }
            else {
                ArrayList<String> arrayList=maxLengSting(string);
                for (String sting:arrayList) {
                    System.out.print(sting);
                }
                if (arrayList.size()>0)
                    System.out.println(","+arrayList.get(0).length());
                else
                    System.out.println(""+","+0);
            }

        }
    }
    public static ArrayList<String> maxLengSting(String string){
        ArrayList<String> arrayList=new ArrayList<>();
        string=string.replaceAll("\\D+",",");
        String[] strings=string.split(",");
        int max=0;
        for (String str:strings) {
            if (str.length()>max)
                max=str.length();
        }
        for (String str:strings) {
            if (str.length()==max)
                arrayList.add(str);
        }
        return arrayList;
    }
}

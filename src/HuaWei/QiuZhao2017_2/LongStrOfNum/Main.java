package HuaWei.QiuZhao2017_2.LongStrOfNum;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/6.
 * 牛客网试题广场。
 * 请一个在字符串中找出连续最长的数字串，并把这个串的长度返回如果存在长度相同的连续数字串，返回最后一个连续数字串；
 * 注意：数字串只需要是数字组成的就可以，并不要求顺序，比如数字串“1234”的长度就小于数字串“1359055”，
 * 如果没有数字，则返回空字符串（""）而不是NULL！
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            if (string==null||string.length()<1){
                System.out.println("");
            }
            else {
                ArrayList<String> arrayList=maxLengSting(string);
                if (arrayList.size()>0){
                    //最后一个最长的数字串
                    System.out.println(arrayList.get(arrayList.size()-1));
                }else
                    System.out.println("");
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

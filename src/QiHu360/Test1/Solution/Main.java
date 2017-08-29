package QiHu360.Test1.Solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by tzy on 2017/3/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            int count=0;
            for (int n=2;n<=str.length();n++){
                for (int i=0;i<=str.length()-n;i++){
                    String temp=str.substring(i,i+n);
                    if (isOshu(temp))
                        count++;
                }
                n++;
            }
            System.out.println(count);
        }
    }
    public static boolean isOshu(String str){
        Map<Character,Integer> hasMap=new HashMap<>();
        for (int i=0;i<str.length();i++){
            if (hasMap.containsKey(str.charAt(i))) {
                int value = hasMap.get(str.charAt(i));
                value++;
                hasMap.put(str.charAt(i),value);
            }
            else
                hasMap.put(str.charAt(i),1);
        }
        Iterator iterator=hasMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry= (Map.Entry) iterator.next();
            int val= (int) entry.getValue();
            if ((val&1)==1)
                return false;
        }
        return true;
    }
}

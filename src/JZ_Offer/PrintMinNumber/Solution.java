package JZ_Offer.PrintMinNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tzy on 2017/3/24.
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if (numbers==null||numbers.length==0)
            return "";
        StringBuffer stringBuffer=new StringBuffer();
        ArrayList<Integer> list=new ArrayList<>();
        for (int number:numbers) {list.add(number);}
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        /*
        Collections.sort(list,(Integer str1, Integer str2)-> {
            String s1=str1+""+str2;
            String s2=str2+""+str1;
            return s1.compareTo(s2);}
        );
         */
        for(Integer integer:list){stringBuffer.append(integer);}
        return stringBuffer.toString();
    }
}


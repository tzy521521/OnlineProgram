package HuaWei.Chorusline.Solution7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tzy on 2017/8/8.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Character> arrayList3=new ArrayList<>();
        arrayList3.addAll(Arrays.asList('a','c','f','s','e','a'));
        ArrayList<Character> arrayList4=new ArrayList<>();
        arrayList4.addAll(Arrays.asList('f','c','e','s','a','a'));

        ArrayList<Character> arrayList5=LCS(arrayList3,arrayList4);
        System.out.println(arrayList5);
    }

    public static <T>ArrayList<T> LCS(ArrayList<T>arrayList1,ArrayList<T> arrayList2){
        if (arrayList1.size()==0||arrayList2.size()==0){
            ArrayList<T> arrayList=new ArrayList<>();
            return arrayList;
        }else if (arrayList1.get(arrayList1.size()-1)==arrayList2.get(arrayList2.size()-1)){
            T t=arrayList1.get(arrayList1.size()-1);

            arrayList1.remove(arrayList1.size()-1);
            arrayList2.remove(arrayList2.size()-1);

            ArrayList<T>arrayList=LCS(arrayList1,arrayList2);
            arrayList.add(t);
            return arrayList;
        }else {

            ArrayList<T> arrayList_1=new ArrayList<>();
            arrayList_1.addAll(arrayList1);
            arrayList_1.remove(arrayList_1.size()-1);
            ArrayList<T>list1=LCS(arrayList_1,arrayList2);

            ArrayList<T> arrayList_2=new ArrayList<>();
            arrayList_2.addAll(arrayList2);
            arrayList_2.remove(arrayList_2.size()-1);
            ArrayList<T>list2=LCS(arrayList1,arrayList_2);

            if (list1.size()>list2.size())
                return list1;
            else
                return list2;
        }
    }
}

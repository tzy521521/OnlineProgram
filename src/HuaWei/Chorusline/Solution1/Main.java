package HuaWei.Chorusline.Solution1;

import java.util.*;

/**
 * Created by tzy on 2017/8/5.
 * 出列之后剩下的可以重排，最简单啊
 */
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            int numbers=input.nextInt();
            int[] students=new int[numbers];
            for (int i = 0; i <numbers ; i++) {
                students[i]=input.nextInt();
            }
            System.out.println(students.length-chorusline(students));
        }
    }
    public static int chorusline(int[] students){
        Arrays.sort(students);
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int num=0;
        for (int i = 0; i <students.length-1 ; i++) {
            if (students[i]<students[students.length-1]){
                if (hashMap.get(students[i])==null)
                    hashMap.put(students[i],1);
                else {
                    int value=hashMap.get(students[i]);
                    value++;
                    hashMap.put(students[i],value);
                }
            }
        }
        for (Integer integer :hashMap.values()) {
            if (integer<3)
                num+=integer;
        }
        return num+1;
    }
}

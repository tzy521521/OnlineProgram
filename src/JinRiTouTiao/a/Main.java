package JinRiTouTiao.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tzy on 2017/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<Integer> arrayList=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                arrayList.add(scanner.nextInt());
            }
            System.out.println(relNums(arrayList));
        }
    }
    public static int relNums(ArrayList<Integer> arrayList){
        if (arrayList==null||arrayList.size()<1)
            return 3;
        Collections.sort(arrayList);
        Stack<ArrayList<Integer>> stack=new Stack<>();
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arrayList.get(0));
        stack.push(temp);
        for (int i = 1; i <arrayList.size() ; i++) {
            if (arrayList.get(i)-arrayList.get(i-1)<=10)
               stack.peek().add(arrayList.get(i));
            else {
                ArrayList<Integer> temp0=new ArrayList<>();
                temp0.add(arrayList.get(i));
                stack.push(temp0);
            }
        }
        int num=0;
        for (ArrayList<Integer> temp1:stack) {
            if (temp1.size()%3!=0){
                num+=3-temp1.size()%3;
            }
        }
        return num;
    }
}

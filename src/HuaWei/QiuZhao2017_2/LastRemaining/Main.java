package HuaWei.QiuZhao2017_2.LastRemaining;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/6.
 * 牛客网剑指Offer。
 * 100个人围成一圈，每个人有一个编码，编号从1到100。他们从1开始依次报数，报到M的人自动退出圆圈，
 * 然后下一个人接着从1开始报数，知道剩余的人数小于M。请问最后剩余的人的原先的编号是多少？
 * 例如输入M=3，输出为：58,91。
 * 如果输入的M大于等于100，则输出"ERROR";M小于等于1，则输出"ERROR";
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int m=scanner.nextInt();
            if (m>=100||m<=1){
                System.out.println("ERROR");
            }
            ArrayList<Integer> arrayList=lastRemaining_Solution(m);
            for (int i = 0; i <arrayList.size()-1 ; i++) {
                System.out.print(arrayList.get(i)+",");
            }
            System.out.println(arrayList.get(arrayList.size()-1));
        }
    }
    public static ArrayList<Integer> lastRemaining_Solution(int m) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 1; i <=100 ; i++) {
            arrayList.add(i);
        }
        int index=0;
        while (arrayList.size()>=m){
            for (int i = 0; i <m ; i++) {
                ++index;
                if (index>arrayList.size()-1)
                    index=0;
            }
            if (index==0)
                arrayList.remove(arrayList.size()-1);
            else
                arrayList.remove(--index);
        }
        return arrayList;
    }
}

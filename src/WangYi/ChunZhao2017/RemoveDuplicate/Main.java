package WangYi.ChunZhao2017.RemoveDuplicate;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Created by tzy on 2017/8/31.
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。
 * 输入包括两行：第一行为序列长度n(1 ≤ n ≤ 50)
 * 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔
 * 输出消除重复元素之后的序列，以空格分隔，行末无空格(注意)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[]temp=new int[n];
            LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>();
            for (int i = 0; i <n ; i++) {
                temp[i]=scanner.nextInt();
            }
            for (int i = n-1; i >=0 ; i--) {
                linkedHashSet.add(temp[i]);
            }
            ArrayList<Integer> arrayList=new ArrayList<>();
            arrayList.addAll(linkedHashSet);
            for (int i = arrayList.size()-1; i >0 ; i--) {
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println(arrayList.get(0));
        }
    }
}

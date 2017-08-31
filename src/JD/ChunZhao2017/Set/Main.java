package JD.ChunZhao2017.Set;

import java.util.*;

/**
 * Created by tzy on 2017/8/31.
 * 给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素。
 * 每组输入数据分为三行,第一行有两个数字n,m(0 ≤ n,m ≤ 10000)，分别表示集合A和集合B的元素个数。后两行分别表示集合A和集合B。每个元素为不超过int范围的整数,每个元素之间有个空格隔开。
 * 针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开。
 * （注意有的题目要求五空格。）
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int Anum=scanner.nextInt();
            int Bnum=scanner.nextInt();
            TreeSet<Integer> treeSet=new TreeSet<>();
            for (int i = 0; i <Anum+Bnum ; i++) {
                treeSet.add(scanner.nextInt());
            }
            ArrayList<Integer> arrayList=new ArrayList<>();
            arrayList.addAll(treeSet);
            for (int i = 0; i <arrayList.size()-1 ; i++) {
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println(arrayList.get(arrayList.size()-1));
        }
    }
}

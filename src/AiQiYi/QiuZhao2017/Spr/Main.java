package AiQiYi.QiuZhao2017.Spr;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            System.out.println(seuerNums(n,m));
        }
    }
    public static int seuerNums(int n,int m){
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            ArrayList<Integer> arrayList=new ArrayList<>();
            for (int j = 1; j <=(int)Math.sqrt(m) ; j++) {
                if (i*(int)Math.pow(j,2)<=m)
                    arrayList.add(i*(int)Math.pow(j,2));
            }
            arrayLists.add(arrayList);
        }
        int sum=0;
        for (ArrayList<Integer> a:arrayLists) {
            sum+=a.size();
        }
        return sum;
    }
}

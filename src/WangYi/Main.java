package WangYi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
            for (int i = 0; i <num ; i++) {
                ArrayList<Integer> arrayList=new ArrayList<>();
                int n=scanner.nextInt();
                for (int j = 0; j <n ; j++) {
                    arrayList.add(scanner.nextInt());
                }
                arrayLists.add(arrayList);
            }
            ArrayList<String> rest=test(arrayLists);
            for (String flag:rest) {
                System.out.println(flag);
            }
        }
    }
    public static ArrayList<String> test(ArrayList<ArrayList<Integer>> arrayLists){
        ArrayList<String> resut=new ArrayList<>();
        for (ArrayList<Integer> list:arrayLists) {
            int[] A=new int[list.size()];
            for (int i = 0; i <list.size() ; i++) {
                A[i]=list.get(i);
            }
            if (isKeXing(A))
                resut.add("Yes");
            else
                resut.add("NO");
        }
        return resut;
    }
    public static boolean isKeXing(int[] A){
        int total=1;
        for (int i = 0; i <A.length ; i++) {
            total*=A[i];
        }
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        for (int i = 0; i <B.length ; i++) {
            B[i]/=A[A.length-1-i];
        }
        boolean flag=false;
        for (int i = 0; i <B.length ; i++) {
            if (total*B[i]%4==0)
                flag=true;
        }
        return flag;
    }
}

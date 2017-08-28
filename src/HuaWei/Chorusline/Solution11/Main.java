package HuaWei.Chorusline.Solution11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/8/10.
 * 最长递增子序列：只是求出长度。最好的情况O(n),最坏的情况是O(n2)
 */
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (input.hasNext()) {
            int nums = input.nextInt();
            int[] students = new int[nums];
            int[] destudents=new int[nums];
            for (int i = 0; i < students.length; i++) {
                students[i] = input.nextInt();
                destudents[--nums]=students[i];
            }
            System.out.println(LIS(students));
        }
    }
    public static int LIS(int[] students){
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(students[0]);
        for (int i = 1; i <students.length ; i++) {
            if (arrayList.get(arrayList.size()-1)<students[i])
                arrayList.add(students[i]);
            else {
                int k=0;
                while (k<arrayList.size()-1){
                    if (arrayList.get(k)<students[i])
                        k++;
                    else
                        break;
                }
                arrayList.set(k,students[i]);
            }
        }
        System.out.println(arrayList);
       return arrayList.size();
    }
}

package HuaWei.Chorusline.Solution12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tzy on 2017/8/10.
 * 最长递增子序列：只是求出长度。最好的情况O(n),最坏的情况是O(nlogn)
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
                int k= Collections.binarySearch(arrayList,students[i]);
                if (k<0)
                    arrayList.set(-k-1,students[i]);
            }
        }
       return arrayList.size();
    }
}

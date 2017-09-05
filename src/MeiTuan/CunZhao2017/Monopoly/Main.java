package MeiTuan.CunZhao2017.Monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] nums=new int[n];
            for (int i = 0; i <n ; i++) {
                nums[i]=scanner.nextInt();
            }
            System.out.println(maxMain(nums));
        }
    }
    public static int maxMain(int[] nums){
        int max=0;
        for (int i = 1; i <=nums.length ; i++) {
            ArrayList<Integer> arrayList=minInWindows(nums,i);
            Collections.sort(arrayList);
            int temp=(i)*arrayList.get(arrayList.size()-1);
            if (temp>max)
                max=temp;
        }
        return max;
    }
    public static ArrayList<Integer> minInWindows(int [] num, int size) {
        int temp[]=new int[num.length];
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (size>0){
            for (int i=0;i<=num.length-size;i++){
                System.arraycopy(num,i,temp,i,size);
                Arrays.sort(temp,i,i+size);
                arrayList.add(temp[i]);
            }
        }
        return arrayList;
    }
    /*
    public static int maxMain(int[] nums){
        int max=0;
        int[] array=new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i; j <nums.length ; j++) {
                System.arraycopy(nums,i,array,i,j+1-i);
                Arrays.sort(array,i,j+1);
                int temp=(j+1-i)*array[i];
                if (temp>max)
                    max=temp;
            }
        }
        return max;
    }
     */

}

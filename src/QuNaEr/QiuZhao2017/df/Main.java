package QuNaEr.QiuZhao2017.df;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            int[] nums=new int[n];
            for (int i = 0; i <n ; i++) {
                nums[i]=scanner.nextInt();
            }
            isCanbe(nums,k);
        }
    }
    public static void isCanbe(int[] nums,int k){

    }
}

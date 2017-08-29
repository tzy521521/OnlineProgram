package HuaWei.Chorusline;

import java.util.Scanner;

/**
 * Created by tzy on 2017/8/9.
 * //如果students[i]之前没有比他小的数，那么students[i]自身构成一个长度为1的以students[i]为末元素的递增子序列。
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
            int[] count1=LIS(students);
            int[] count2=LIS(destudents);
            int max=0;int j=count2.length;
            for (int i = 0; i <count1.length ; i++) {
                int value=count1[i]+count2[--j];
                if (value>max)
                    max=value;
            }
            System.out.println(count1.length-max+1);
        }
    }
    //求递增计数。
    public static int[] LIS(int[] students){
        int[] f=new int[students.length];
        f[0]=1;
        for (int i = 1; i <students.length ; i++) {
            int max=0;
            for (int j = 0; j <i ; j++) {
                if (students[j]<students[i]&&f[j]>max)
                    max=f[j];
            }
            f[i]=max+1;
        }
        return f;
    }
}

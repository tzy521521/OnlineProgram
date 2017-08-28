package HuaWei.Chorusline.Solution10;

import javax.xml.soap.SAAJMetaFactory;
import java.util.ArrayList;
import java.util.Arrays;
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
            /*

             */
            int length=0;
            for (int i = 0; i <count1.length ; i++) {
                if (count1[i]>length)
                    length=count1[i];
            }
            System.out.println(length);
            ArrayList<ArrayList<Integer>> arrayLists=seqLISs(students,count1,length);
            for (ArrayList<Integer> arrayList: arrayLists) {
                System.out.println(arrayList);
            }

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

    //输出所有的递增子序列，不完整。
    public static ArrayList<ArrayList<Integer>> seqLISs(int[] students,int[] count,int length){
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
        for (int i = 0; i <count.length ; i++) {
            if (count[i]==length)
                arrayLists.add(seqLIS(students,count,i));
        }
        return arrayLists;
    }
    public static ArrayList<Integer> seqLIS(int[] students,int[] count,int index){
        ArrayList<Integer> arrayList=new ArrayList<>();
        int k=count[index];
        for (int i = index; i >=0 ; i--) {
            if (count[i]==k){
                arrayList.add(students[i]);
                k--;
            }
        }
        return arrayList;
    }
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

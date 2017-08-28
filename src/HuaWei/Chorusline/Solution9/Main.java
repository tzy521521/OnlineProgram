package HuaWei.Chorusline.Solution9;

import java.util.*;

/**
 * Created by tzy on 2017/8/8.
 * 这里求最长递增子序列。
 */
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (input.hasNext()) {
            int nums = input.nextInt();
            int[] students = new int[nums];
            for (int i = 0; i < nums; i++) {
                students[i] = input.nextInt();
            }
            int[] count=cout(students);
            Arrays.sort(count);
            System.out.println(nums-count[nums-1]);
        }
    }
    public static int[] cout(int[] students){
        int[] count=new int[students.length];
        for (int i = 0; i <students.length-1; i++) {
            int[] lef=new int[i+1];
            System.arraycopy(students,0,lef,0,lef.length);

            int[] temp=new int[students.length-lef.length];
            System.arraycopy(students,i+1,temp,0,temp.length);
            int[] right=new int[temp.length];
            int k=0;
            for (int j = temp.length-1; j >=0 ; j--) {
                right[k++]=temp[j];
            }

            int lefcount=count(lef);
            int rightcount=count(right);
            count[i]=lefcount+rightcount;
        }
        return count;
    }
    public static int count(int[] students){
            TreeSet<Integer> asstu=new TreeSet<>();
            for (int j = 0; j <students.length ; j++) {
                asstu.add(students[j]);
            }
            Object[] temp=asstu.toArray();
            int[] acesutd=new int[temp.length];
            for (int j = 0; j <acesutd.length; j++) {
                acesutd[j]=(int)temp[j];
            }
        return length_LCS(students,acesutd);
    }
    public static int length_LCS(int[] str1, int[] str2) {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        int[][]table = new int[substringLength1 + 1][substringLength2 + 1];

        // 从后向前，动态规划计算所有子问题。
        for (int i = substringLength1 - 1; i >= 0; i--) {
            for (int j = substringLength2 - 1; j >= 0; j--) {
                if (str1[i] == str2[j])
                    table[i][j] = table[i + 1][j + 1] + 1;
                else
                    table[i][j] = Math.max(table[i + 1][j], table[i][j + 1]);
            }
        }
        return table[0][0];
    }
}

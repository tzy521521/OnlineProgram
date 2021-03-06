package SouHu.QiuZhao2017;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by tzy on 2017/9/17.
 * 找出和最大的最长公共子序列。只是通过80%
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            String[] num=new String[n];
            String[] renum=new String[n];
            int tatol=0;
            for (int i = 0; i <n ; i++) {
                num[i]=scanner.next();
                renum[n-1-i]=num[i];
                tatol+=Integer.valueOf(num[i]);
            }
            TreeSet<String> set= sequence_LCS(num,renum);
            int max=0;
            for(String s : set) {
                String[] nums=s.split("\\s+");
                int tem=0;
                for (int i = 0; i <nums.length ; i++) {
                    tem+=Integer.valueOf(nums[i]);
                }
                if (tem>max)
                    max=tem;
            }
            System.out.println(tatol-max+tatol);
        }
    }
    private static int[][] table;
    private static TreeSet<String> set = new TreeSet<>();
    //求最长公共子序列的长度。
    private static int length_LCS(String[] str1, String[] str2) {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;
        // 构造二维数组记录子问题的LCS的长度
        table = new int[substringLength1 + 1][substringLength2 + 1];
        // 从前向后，动态规划计算所有子问题。第一行和第一列置为0
        for (int i = 1; i <substringLength1+1 ; i++) {
            for (int j = 1; j <substringLength2+1 ; j++) {
                if (str1[i-1].equals(str2[j-1]))
                    table[i][j] = table[i - 1][j - 1] + 1;
                else
                    table[i][j]= Math.max(table[i - 1][j], table[i][j - 1]);
            }
        }
        return table[substringLength1][substringLength2];
    }
    //输出所有的最长公共子序列
    private static TreeSet<String> sequence_LCS(String[] string1, String[] string2){
        length_LCS(string1, string2);
        int m=string1.length;
        int n=string2.length;
        String string="";
        traceBack(m,n,string1,string2,string);
        return set;
    }
    private static void traceBack(int i, int j,String[] string1, String[] string2,String string) {
        while (i>0 && j>0) {
            if (string1[i-1].equals(string2[j-1])) {
                string=string1[i-1]+" "+string;
                --i;
                --j;
            }
            else {
                if (table[i-1][j] > table[i][j-1])
                    --i;
                else if (table[i-1][j] < table[i][j-1])
                    --j;
                else {
                    traceBack(i-1, j, string1, string2,string);
                    traceBack(i, j-1, string1, string2,string);
                    return;
                }
            }
        }
        set.add(string);
    }
}

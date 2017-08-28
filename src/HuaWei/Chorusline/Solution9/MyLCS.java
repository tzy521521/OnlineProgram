package HuaWei.Chorusline.Solution9;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by tzy on 2017/8/8.
 */
public class MyLCS {

    public static int[][] table;  // 动态规划表
    private static TreeSet<String> set = new TreeSet<>();
    private static ArrayList<ArrayList<Integer>>arrayLists=new ArrayList<>();

    public static int length_LCS(int[] str1, int[] str2) {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        table = new int[substringLength1 + 1][substringLength2 + 1];

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
    public static ArrayList<ArrayList<Integer>> sequence_LCS(int[] stu1, int[] stu2){
        length_LCS(stu1, stu2);

        String string="";
        traceBack(0,0,stu1,stu2,string);
        for (String s:set) {
            String[] temp=s.split("\\s+");
            ArrayList<Integer> arrayList=new ArrayList<>();
            for (int i = 0; i <temp.length ; i++) {
                arrayList.add(Integer.valueOf(temp[i]));
            }
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }
    private static void traceBack(int i, int j,int[] stu1, int[] stu2,String string) {

        while (i<stu1.length && j<stu2.length) {
            if (stu1[i] == stu2[j]) {
                string+=stu1[i]+" ";
                ++i;
                ++j;
            }
            else {
                if (table[i+1][j] > table[i][j+1])
                    ++i;
                else if (table[i+1][j] < table[i][j+1])
                    ++j;
                else {  // 相等的情况
                    traceBack(i+1, j, stu1, stu2,string);
                    traceBack(i, j+1, stu1, stu2,string);
                    return;
                }
            }
        }
        set.add(string);
    }
}

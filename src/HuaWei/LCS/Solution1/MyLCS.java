package HuaWei.LCS.Solution1;

import java.util.TreeSet;

/**
 * Created by tzy on 2017/8/8.
 * 最长公共子序列的动态规划算法。并且输出所有的最长公共子序列。
 */
public class MyLCS {
    private static int[][] table;
    private static TreeSet<String> set = new TreeSet<>();

    public static int length_LCS(String string1, String string2){
        return length_LCS(string1.toCharArray(),string2.toCharArray());
    }
    //求最长公共子序列的长度。
    public static int length_LCS(char[] str1, char[] str2) {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;
        // 构造二维数组记录子问题的LCS的长度
        table = new int[substringLength1 + 1][substringLength2 + 1];
        // 从后向前，动态规划计算所有子问题。最后一行和最后一列置为0
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
    //输出所有的最长公共子序列
    public static TreeSet<String> sequence_LCS(String string1, String string2){
        length_LCS(string1, string2);
        String string="";
        traceBack(0,0,string1,string2,string);
        return set;
    }
    private static void traceBack(int i, int j,String string1, String string2,String string) {
        while (i<string1.length() && j<string2.length()) {
            if (string1.charAt(i)==string2.charAt(j)) {
                string+=string1.charAt(i);
                ++i;
                ++j;
            }
            else {
                if (table[i+1][j] > table[i][j+1])
                    ++i;
                else if (table[i+1][j] < table[i][j+1])
                    ++j;
                else {
                    traceBack(i+1, j, string1, string2,string);
                    traceBack(i, j+1, string1, string2,string);
                    return;
                }
            }
        }
        set.add(string);
    }
}

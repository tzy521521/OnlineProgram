package HuaWei.Chorusline.Solution5;

import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by tzy on 2017/8/6.
 */
public class LongestCommonSubsequence {

    private TreeSet<String> set = new TreeSet<>();

    public static int[][] compute0(char[] str1, char[] str2){

        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

        // 从前向后，动态规划计算所有子问题。第一行和第一列置为0
        for (int i = 1; i <substringLength1+1 ; i++) {
            for (int j = 1; j <substringLength2+1 ; j++) {
               if (str1[i-1] == str2[j-1])
                    opt[i][j] = opt[i - 1][j - 1] + 1;
                else
                    opt[i][j]= Math.max(opt[i - 1][j], opt[i][j - 1]);
            }
        }
        int i = substringLength1-1, j = substringLength2-1;
        StringBuffer strBuf=new StringBuffer();
        while (i >=0 && j >=0) {
            if (str1[i] == str2[j]) {
                strBuf.append(str1[i]);
                i--;
                j--;
            }
            else if (opt[i - 1][j] >= opt[i][j - 1])
                i--;
            else
                j--;
        }
        System.out.println(strBuf.reverse().toString());
        return opt;
    }

    public static int[][] compute0(String str1, String str2) {
        return compute0(str1.toCharArray(), str2.toCharArray());
    }

    public static int[][] compute(char[] str1, char[] str2) {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

        // 从后向前，动态规划计算所有子问题。
        for (int i = substringLength1 - 1; i >= 0; i--) {
            for (int j = substringLength2 - 1; j >= 0; j--) {
                if (str1[i] == str2[j])
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
            }
        }
        System.out.println("substring1:" + new String(str1));
        System.out.println("substring2:" + new String(str2));
        System.out.print("LCS:");

        int i = 0, j = 0;
        while (i < substringLength1 && j < substringLength2) {
            if (str1[i] == str2[j]) {
                System.out.print(str1[i]);
                i++;
                j++;
            }
            else if (opt[i + 1][j] >= opt[i][j + 1])
                i++;
            else
                j++;
        }
        System.out.println();
        return opt;
    }

    public static int[][] compute(String str1, String str2) {
        return compute(str1.toCharArray(), str2.toCharArray());
    }
}

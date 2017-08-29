package HuaWei.LCS0;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/8/12.
 * 最长公共字串
 */
public class MyLCS0 {
    private static int[][] table;  // 动态规划表
    private static ArrayList<String> arrayList=new ArrayList<>();
    private static int biggest=0;

    public static int length_LCS(String string1, String string2){
        return length_LCS(string1.toCharArray(),string2.toCharArray());
    }
    public static int length_LCS(char[] str1, char[] str2) {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;
        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        table = new int[substringLength1 + 1][substringLength2 + 1];
        // 从前向后，动态规划计算所有子问题。第一行和第一列置为0
        for (int i = 1; i <substringLength1+1 ; i++) {
            for (int j = 1; j <substringLength2+1 ; j++) {
                if (str1[i-1] == str2[j-1]){
                    table[i][j] = table[i - 1][j - 1] + 1;
                    if (table[i][j]>biggest)
                        biggest=table[i][j];
                } else
                    table[i][j]= 0;
            }
        }
        return biggest;
    }

    public static ArrayList<String> sequence_LCS(String string1, String string2){
        length_LCS(string1, string2);
        return sequence_LCS(string1,string2,biggest);
    }
    private static ArrayList<String> sequence_LCS(String string1, String string2,int biggest){
        for (int i = 0; i <string1.length()+1 ; i++) {
            for (int j = 0; j <string2.length()+1; j++) {
                if (table[i][j]==biggest){
                    String string=string1.substring(i-biggest,i);
                    arrayList.add(string);
                }
            }
        }
        return arrayList;
    }
}

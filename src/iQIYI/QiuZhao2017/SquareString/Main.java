package iQIYI.QiuZhao2017.SquareString;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/7.
 * 问题转换成求两个字符串的最长公共子序列的长度。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.next();
            int max=0;
            for (int i = 1; i <string.length() ; i++) {
                String str1=string.substring(0,i);
                String str2=string.substring(i);
                max=Math.max(max,LCS(str1,str2));
            }
            System.out.println(max*2);
        }
    }
    private static int LCS(String string1,String string2){

        int[][]dp=new int[string1.length()+1][string2.length()+1];
        for (int i = 1; i <=string1.length() ; i++) {
            for (int j = 1; j <=string2.length() ; j++) {
                if (string1.charAt(i-1)==string2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[string1.length()][string2.length()];
    }
}

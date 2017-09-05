package MeiTuan.CunZhao2017.LCS0;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/5.
 * (最长公共字串)
 * 给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string1=scanner.nextLine();
            String string2=scanner.nextLine();
            System.out.println(length_LCS(string1,string2));
        }
    }
    public static int length_LCS(String string1, String string2){
        if (string1==null||string2==null||string1.length()<1||string2.length()<1)
            return 0;
        int row=string1.length()+1;
        int colwn=string2.length()+1;
        int[][] table=new int[row][colwn];
        int max=0;
        for (int i = 1; i <string1.length()+1 ; i++) {
            for (int j = 1; j <string2.length()+1 ; j++) {
                if (string1.charAt(i-1)==string2.charAt(j-1)){
                    table[i][j]=table[i-1][j-1]+1;
                    if (table[i][j]>max)
                        max=table[i][j];
                }
                else {
                    table[i][j]=0;
                }
            }
        }
        return max;
    }
}

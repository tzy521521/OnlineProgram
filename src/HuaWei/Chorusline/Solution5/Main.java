package HuaWei.Chorusline.Solution5;

/**
 * Created by tzy on 2017/8/6.
 */
public class Main {
    public static void main(String[] args) {
        String a = "BDCABA";
        String b = "ABCBDAB";
        int[][]temp=LongestCommonSubsequence.compute(a, b);

        for (int i = 0; i <temp.length ; i++) {
            for (int j = 0; j <temp[0].length ; j++) {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~~`");
        int[][]temp0=LongestCommonSubsequence.compute0(a, b);
        for (int i = 0; i <temp0.length ; i++) {
            for (int j = 0; j <temp0[0].length ; j++) {
                System.out.print(temp0[i][j]+" ");
            }
            System.out.println();
        }
    }
}

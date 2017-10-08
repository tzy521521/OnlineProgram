package Ctrip.Qiuzhao2017.MinimumDeletion.Solution1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/21.
 * 找到缺失的最小正整数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int A[]=new int[n];
            for (int i = 0; i <n ; i++) {
                A[i]=scanner.nextInt();
            }
            System.out.println(firstMissingPositive(A));
        }
    }
    private static int firstMissingPositive(int[] A) {
        Arrays.sort(A);
        int result = 1;
        for (int a : A) {
            if (a > 0) {
                if (result == a)
                    result++;
                else
                    return result;
            }
        }
        return result;

    }
}

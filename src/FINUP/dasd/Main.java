package FINUP.dasd;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/10.
 * 题目忘记了~~~网上找的AC
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String [] intValue=scanner.nextLine().split("\\s+");
            int[] nums=new int[intValue.length];
            for (int i = 0; i <intValue.length ; i++) {
                nums[i]=Integer.valueOf(intValue[i]);
            }
            System.out.println(solve(nums));
        }
    }
    public static int solve(int[] nums){
        int n = nums.length;
        int[] sum = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for(int idx = 1; idx <= n; idx++){
            sum[idx] = sum[idx - 1] + nums[idx - 1];
            dp[idx][1] = sum[idx];
        }
        int max = dp[n][0];

        for(int numOfDigitsInTotal = 2; numOfDigitsInTotal <= n; numOfDigitsInTotal++){

            for(int numOfDigitsWithMult = 2; numOfDigitsWithMult <= numOfDigitsInTotal; numOfDigitsWithMult++){

                for(int splitPointBetweenAddAndMult = numOfDigitsWithMult; splitPointBetweenAddAndMult <= numOfDigitsInTotal; splitPointBetweenAddAndMult++){
                    dp[numOfDigitsInTotal][numOfDigitsWithMult] = Math.max(dp[numOfDigitsInTotal][numOfDigitsWithMult],
                            dp[splitPointBetweenAddAndMult - 1][numOfDigitsWithMult - 1] * (sum[numOfDigitsInTotal] - sum[splitPointBetweenAddAndMult - 1]));
                }
                if(numOfDigitsInTotal == n && dp[n][numOfDigitsWithMult] > max){
                    max = dp[n][numOfDigitsWithMult];
                }
            }
        }
        return max;
    }
}

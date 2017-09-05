package XieCheng.ChunZhao2017.FindGreatestSumOfSubArray;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/5.
 * 剑指offer的题
 * 输入一个整形数组。
 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 输入:给定一个数组，包含若干个整数。(1 -3 5 5 -6 -2 -7)
 * 输出测试数组中子数组所能产生的最大和(10)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings=scanner.nextLine().split("\\s+");
            int[] nums=new int[strings.length];
            for (int i = 0; i <strings.length ; i++) {
                nums[i]=Integer.valueOf(strings[i]);
            }
            int max=nums[0];
            int tatol=max;
            for (int i = 1; i <nums.length ; i++) {
                if (tatol>0){
                    tatol+=nums[i];
                }else {
                    tatol=nums[i];
                }
                if (tatol>max)
                    max=tatol;
            }
            System.out.println(max);
        }
    }
}

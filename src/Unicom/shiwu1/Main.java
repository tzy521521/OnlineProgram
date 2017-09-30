package Unicom.shiwu1;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/27.
 * 食物价值。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }
            System.out.println(maxPrice(prices));
        }
    }
    private static long maxPrice(int[] prices){
        int maxValue=0;
        int count=1;
        int low=0;
        int heigh=prices.length-1;
        int[] value=new int[prices.length];
        for (int i = 0; i <prices.length ; i++) {
            value[i]=prices[i];
        }
        while (low<=heigh){
            if (value[low]<value[heigh]){
                maxValue+=value[low];
                low++;
            }else {
                maxValue+=value[heigh];
                heigh--;
            }
            count++;
            for (int i = low; i <=heigh ; i++) {
                value[i]=prices[i]*count;
            }
        }
        return maxValue;
    }
}
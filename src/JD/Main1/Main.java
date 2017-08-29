package JD.Main1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tzy on 2017/4/7.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[] prices=new int[m];
            for (int i = 0; i <m ; i++) {
                prices[i]=scanner.nextInt();
            }
            System.out.println(liRun(n,prices));
        }
    }
    public static int liRun(int n,int[] prices){
        Arrays.sort(prices);
        int max=prices[prices.length-1]*1;
        int index=prices.length-1;
        int low=0;
        if (prices.length>n)
            low=prices.length-n;
        for (int i = prices.length-2; i >=low ; i--) {
            int temp=prices[i]*(prices.length-i);
            if (temp>=max)
            {
                max=temp;
                index=i;
            }
        }
        return prices[index];
    }
}

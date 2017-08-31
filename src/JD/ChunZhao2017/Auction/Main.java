package JD.ChunZhao2017.Auction;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tzy on 2017/4/7.
 * 公司最近新研发了一种产品，共生产了n件。有m个客户想购买此产品，第i个客户出价Vi元。为了确保公平，公司决定要以一个固定的价格出售产品。
 * 每一个出价不低于要价的客户将会得到产品，余下的将会被拒绝购买。请你找出能让公司利润最大化的售价。
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
        //最大利润
        int max=0;
        //利润最大化售价
        int price=0;
        for (int i = 0; i <prices.length ; i++) {
            if (prices.length-i>=n){
                //可以购买该产品的用户数目不小于产品数。
                if (prices[i]*n>max){
                    max=prices[i]*n;
                    price=prices[i];
                }
            }else {
                if (prices[i]*(prices.length-i)>max){
                    max=prices[i]*(prices.length-i);
                    price=prices[i];
                }
            }
        }
        return price;
    }
}

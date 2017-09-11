package FanPuJInKe.Hide;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            long n=scanner.nextLong();
            System.out.println(minHide(n));
        }
    }
    public static long minHide(long n){
        long index=n;
        while (n<Long.MAX_VALUE){
            if (index-sum(index)>=n)
                break;
            index++;
        }
        return index;
    }
    public static long sum(long n){
        long sum=0;
        while (n!=0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}

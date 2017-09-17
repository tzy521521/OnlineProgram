package ofo.DigitalTransformation;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/14.
 * 一个整数n，如果是偶数可以变换为n/2,如果为技术就可以变换为n+1或者n-1;求变换成1的最小变换次数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            long n=scanner.nextLong();
            System.out.println(replace(n));
        }
    }
    public static int replace(long number){
        if (number==0)
            return 1;
        if (number == 1)
            return 0;
        if (number % 2 == 0) {
            return 1 + replace(number / 2);
        }
        int x = replace(number + 1);
        int y = replace(number - 1);
        if (x > y) {
            return y + 1;
        } else
            return x + 1;
    }
}

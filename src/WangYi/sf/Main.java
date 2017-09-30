package WangYi.sf;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            System.out.println(printProbability(n,k));
        }
    }
    private static int gMaxValue = 6;

    public static void probility(int orignal, int current, int sum, int[] probilities){
        if(current == 1){
            probilities[sum - orignal]++;
        }else{
            for(int i=1; i<= gMaxValue; i++){
                probility(orignal, current - 1, sum + i, probilities);
            }
        }
    }

    public static void probility(int number, int[] probilities){
        for(int i=1; i<= gMaxValue; i++){
            probility(number,number, i,probilities);
        }
    }

    public static String printProbability(int number,int k){
        /*
        if(number < 1)
            return;
         */
        int maxSum = number * gMaxValue;

        int[] probilities = new int[maxSum - number + 1];
        probility(number, probilities);

        int total = (int) Math.pow(gMaxValue, number);

        int sum=0;
        for(int i=number; i<= maxSum; i++){
            if (i>=k)
            sum += probilities[i - number];
        }
        if (sum==0)
            return 0+"";
        else if (sum==total){
            return 1+"";
        }else {
            int gc=gcd(sum,total);
            int fenzi=sum/gc;
            int fenmu=total/gc;
            return fenzi+"/"+fenmu;
        }
    }
    public static int gcd(int m,int n){
        if (m%n==0)
            return n;
        else
            return gcd(n,m%n);
    }
}

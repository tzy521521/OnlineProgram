package WangYi.sdf;

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
    public static String printProbability(int number,int l) {
        int g_maxValue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[g_maxValue * number + 1];
        probabilities[1] = new int[g_maxValue * number + 1];
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++)
            probabilities[0][i] = 1;
        for (int k = 2; k <= number; ++k) {
            for (int i = 0; i < k; ++i)
                probabilities[1 - flag][i] = 0;
            for (int i = k; i <= g_maxValue * k; ++i) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= g_maxValue; ++j)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }
            flag = 1 - flag;
        }
        int total = (int)Math.pow(g_maxValue, number);
        int sum=0;
        for (int i = number; i <= g_maxValue * number; i++) {
            if (i>=l)
                sum+=probabilities[flag][i];
        }
        if (sum==0)
            return "0";
        else if (sum==total){
            return "1";
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

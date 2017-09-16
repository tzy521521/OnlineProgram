package MeiTuan.QiuZhao2017;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            String[] num=new String[n];
            for (int i = 0; i <n ; i++) {
                num[i]=scanner.next();
            }
            int total=0;
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++) {
                    if (i!=j) {
                        if (Integer.valueOf(num[i]+num[j])%7==0)
                            total++;
                    }
                }
            }
            System.out.println(total);
        }
    }
    public static boolean isCanbe7(int n){
        int[] yu={1,3,2,6,4,5};
        int k=-1;
        int sum=0;
        while (n!=0){
            k++;
            sum+=(n%10)*yu[k%6];
            n=n/10;
        }
        if (sum%7==0)
            return true;
        else
            return false;
    }
}

package RenRen.chuxi;

import java.util.Scanner;

/**
 * Created by tzy on 2017/4/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            System.out.println(nanTi(n,m));
        }
    }
    public static int nanTi(int n,int m){
        int count=0;
        int total=240-m;
        int temp=0;
        for (int i = 1; i <=n ; i++) {
            temp+=i*5;
            count++;
            if (temp>total){
                count--;
                break;
            }
        }
        return count;
    }
}

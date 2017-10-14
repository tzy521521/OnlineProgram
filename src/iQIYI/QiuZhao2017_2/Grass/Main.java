package iQIYI.QiuZhao2017_2.Grass;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int t=scanner.nextInt();
            int[] org = new int[t];
            for (int i = 0; i <t ; i++) {
                org[i]=scanner.nextInt();
            }
            String s="";
            for (int j:org) {
                if (j%5==0)
                    s="yang";
                else if (j%5==1)
                    s="niu";
                else if (j%5==2)
                    s="yang";
                else if (j%5==3)
                    s="niu";
                else
                    s="niu";
                System.out.println(s);
            }
        }
    }
}

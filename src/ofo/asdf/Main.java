package ofo.asdf;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            System.out.println(replace(Integer.toBinaryString(n)));
        }
    }
    public static int replace(String string){
        int num=0;
        for (int i = 0; i <string.length() ; i++) {
            if (string.charAt(i)=='1')
                num++;
        }

        return num-1+string.length()-1;
    }
}

package dsf.sa;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/26.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            int years=scanner.nextInt();
            System.out.println(getNums(num,years));
        }
    }
    public static int getNums(int num,int years){
        return getNums(num,years,1);
    }
    private static int getNums(int num,int years,int current){//current当前年份，num牛的数量
        if (current==years)
            return num;
        else {
            num=num*3-current*2;
            current++;
            return getNums(num,years,current);
        }
    }
}

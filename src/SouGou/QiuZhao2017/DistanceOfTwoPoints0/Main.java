package SouGou.QiuZhao2017.DistanceOfTwoPoints0;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/8.
 * 只能通过50%
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<Double> arrayList=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                arrayList.add(scanner.nextDouble());
            }
            Double max=Double.MIN_VALUE;
            //很简单就是两个for循环遍历，依次求两个点中的最大距离。但是这个代码只能通过50%。
            for (int i = 0; i <arrayList.size() ; i++) {
                for (int j = i+1; j <arrayList.size() ; j++) {
                    Double dif=Math.abs(arrayList.get(j)-arrayList.get(i));
                    if (dif>180)
                        dif=360-dif;
                    if (dif>max)
                        max=dif;
                }
            }
            //System.out.printf("%.8f",max);
            System.out.println(String.format("%.8f",max));
        }
    }
}

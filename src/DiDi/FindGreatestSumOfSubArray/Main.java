package DiDi.FindGreatestSumOfSubArray;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] array=new int[n];
            for (int i = 0; i <n ; i++) {
                array[i]=scanner.nextInt();
            }
            System.out.println(findGreatestSumOfSubArray(array));
        }
    }
    private static int findGreatestSumOfSubArray(int[] array) {
        if (array==null||array.length==0)
            return 0;
        int max=array[0];
        int tatol=array[0];
        for (int i = 1; i <array.length ; i++) {
            if (tatol>0)
                tatol+=array[i];
            else
                tatol=array[i];
            if (tatol>max)
                max=tatol;
        }
        return max;
    }
}

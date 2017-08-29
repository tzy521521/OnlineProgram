package RenRen.xiaoB.solution;

import java.util.Scanner;

/**
 * Created by tzy on 2017/4/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            int[] arr=new int[num];
            for (int i = 0; i <num ; i++) {
                arr[i]=scanner.nextInt();
            }
            System.out.println(solution(arr));
        }
    }
    public static int solution(int[] arr){
        int sum=0;
        for (int i = 0; i <arr.length; i++) {
            sum+=arr[i];
        }
        int answer=0;
        double temp=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            temp+=arr[i];
            if (temp==(sum/2.0))
                answer++;
        }
        return answer;
    }
}

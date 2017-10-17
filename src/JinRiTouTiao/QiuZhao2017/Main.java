package JinRiTouTiao.QiuZhao2017;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int index=scanner.nextInt();
            int[] nums=new int[n];
            for (int i = 0; i <n ; i++) {
                nums[i]=scanner.nextInt();
            }
            int[] weiFen=getWeiFenPei(nums,n,index);
            for (int i = 0; i <n-1 ; i++) {
                System.out.print(weiFen[i]+" ");
            }
            System.out.print(weiFen[n-1]);
        }
    }
    public static int[] getWeiFenPei(int[] nums,int n,int index){
        int min=Integer.MAX_VALUE;
        int minIndex=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]<min){
                min=nums[i];
                minIndex=i;
            }
        }
        int temp=n*min+index;
        nums[minIndex]=temp;
        index=index-1;//数组下标一样
        while (temp!=min){
            if (index<0)
                index=n-1;
            if (index!=minIndex){
                nums[index]=nums[index]-1;
                temp--;
            }
            index--;
        }
        return nums;
    }
}

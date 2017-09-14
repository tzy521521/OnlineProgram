package QuNaEr.QiuZhao2017;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            int[] nums=new int[n];
            for (int i = 0; i <n ; i++) {
                nums[i]=scanner.nextInt();
            }
            isCanbe(nums,k);
        }
    }
    public static void isCanbe(int[] nums,int k){
        Arrays.sort(nums);
        LinkedList<Integer> deque=new LinkedList<>();
        int small=0;int big=1;
        deque.offer(nums[small]);deque.offer(nums[big]);
        int total=nums[small]+nums[big];
        while (small<big&&big<nums.length){
            if (total==k){
                break;
            }else if (total>k){
                if (big!=nums.length-1){
                    total-=nums[small];
                    small++;
                    deque.poll();
                }else {
                    small=0;
                    deque.offer(nums[small]);
                    small++;
                }
            }else {
                big++;
                deque.offer(nums[big]);
                total+=nums[big];
            }
        }
        if (total==k){
            System.out.println("YES");
            for (Integer integer:deque) {
                System.out.print(integer+" ");
            }
        }else {
            System.out.println("NO");
        }
    }
}

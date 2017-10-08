package Ctrip.Qiuzhao2017.MinimumDeletion.Solution0;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/21.
 * 找到缺失的最小正整数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<Long> arrayList=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                arrayList.add(scanner.nextLong());
            }
            System.out.println(firstMissingPositive(arrayList));
        }
    }
    private static long firstMissingPositive(ArrayList<Long> list){
        Long ans = 1l;
        while (true) {
            if (!list.contains(ans)) {
                return ans;
            } else {
                ans++;
            }
        }
    }
}

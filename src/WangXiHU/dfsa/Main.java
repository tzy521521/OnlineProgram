package WangXiHU.dfsa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<String> arrayList=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                arrayList.add(scanner.next().trim());
            }
            ArrayList<int[]> result=changeLess(arrayList);
            for (int[] res:result) {
                System.out.println(res[0]+" "+res[1]);
            }
        }
    }
    public static ArrayList<int[]> changeLess(ArrayList<String> arrayList){
        ArrayList<int[]> result=new ArrayList<>();
        result.add(new int[]{1,1});
        result.add(new int[]{0,-1});
        result.add(new int[]{1,2});
        return  result;
    }
}

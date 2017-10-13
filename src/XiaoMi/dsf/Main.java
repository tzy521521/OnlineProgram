package XiaoMi.dsf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by tzy on 2017/10/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String nums=scanner.nextLine().trim();
            ArrayList<String> arrayList=new ArrayList<>();
            for (int i = 0; i <arrayList.size()-1 ; i++) {
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println(arrayList.get(arrayList.size()-1));
        }
    }
}

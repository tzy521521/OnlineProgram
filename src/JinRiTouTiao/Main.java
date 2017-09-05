package JinRiTouTiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            long n=scanner.nextLong();
            ArrayList<String> arrayList=new ArrayList<>();
            for (long i = 1; i <=n ; i++) {
                arrayList.add(String.valueOf(i));
            }
            int m=scanner.nextInt();
            Collections.sort(arrayList);
            if (m<=n)
                System.out.println(Integer.valueOf(arrayList.get(m-1)));
            else
                System.out.println(-1);
        }
    }
}

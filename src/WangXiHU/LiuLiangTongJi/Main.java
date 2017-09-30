package WangXiHU.LiuLiangTongJi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<String> time=new ArrayList<>();
            ArrayList<Integer> liuliang=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                String[] s1_0= scanner.next().split("\\/");String s1=s1_0[2]+s1_0[0]+s1_0[1];
                String s2= scanner.next();
                int liu=scanner.nextInt();
                time.add(s1+s2);
                liuliang.add(liu);
            }
            int k=scanner.nextInt();
            ArrayList<String[]> timeprio=new ArrayList<>();
            for (int i = 0; i <k ; i++) {
                String[] tims=new String[2];
                String[] s3_0= scanner.next().split("\\/");String s3=s3_0[2]+s3_0[0]+s3_0[1];
                String s4= scanner.next();

                String[] s5_0= scanner.next().split("\\/");String s5=s5_0[2]+s5_0[0]+s5_0[1];
                String s6= scanner.next();
                tims[0]=s3+s4;
                tims[1]=s5+s6;
                timeprio.add(tims);
            }
            ArrayList<Integer> result=cxliu(time,liuliang,timeprio);
            for (Integer integer:result) {
                System.out.println(integer);
            }
        }
    }
    public static ArrayList<Integer> cxliu(ArrayList<String> time,ArrayList<Integer> liuliang,ArrayList<String[]> timeprio){
        ArrayList<Integer> result =new ArrayList<>();
        for (String[] tims:timeprio) {
            int low= Collections.binarySearch(time,tims[0]);
            if (low<0)
                low=-low-1;
            int heigh= Collections.binarySearch(time,tims[1]);
            if (heigh<0)
                heigh=(-heigh-1)-1;
            int total=0;
            for (int i = low; i <=heigh ; i++) {
                total+=liuliang.get(i);
            }
            result.add(total);
        }
        return result;
    }
}

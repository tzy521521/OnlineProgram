package SouGou.ChunZhao2017.Sushu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by tzy on 2017/9/8.
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
            ArrayList<Double> lengths=new ArrayList<>();
            for (int i = 0; i <arrayList.size() ; i++) {
                for (int j = i+1; j <arrayList.size() ; j++) {
                    lengths.add(Math.abs(arrayList.get(j)-arrayList.get(i)));
                }
            }
            System.out.printf("%.8f",sortLength(lengths));
        }

    }
    public static double sortLength(ArrayList<Double> arrayList){
        Collections.sort(arrayList, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(Math.abs(o1-180),Math.abs(o2-180));
            }
        });
        return arrayList.get(0);
    }
}

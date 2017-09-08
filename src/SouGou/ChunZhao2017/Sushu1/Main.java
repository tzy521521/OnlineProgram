package SouGou.ChunZhao2017.Sushu1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tzy on 2017/9/8.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (Double.parseDouble(s)>=180)
                arrayList.add(Math.abs(Double.parseDouble(s)-180));
            else
                arrayList.add(Double.parseDouble(s));
        }
        Collections.sort(arrayList);
        System.out.printf("%.8f", 180.0-(arrayList.get(1)-arrayList.get(0)));
    }

    /*
    public static double sortLength(ArrayList<Double> arrayList) {
        Collections.sort(arrayList, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(Math.abs(o1 - 180), Math.abs(o2 - 180));
            }
        });
        return arrayList.get(0);
    }
     */

}
package WangXiHU.ZiFuMiZhen;

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
            ArrayList<Yongli> arrayList=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                int row=scanner.nextInt();
                int crw=scanner.nextInt();
                char[][] zifu=new char[row][crw];
                for (int j = 0; j <row ; j++) {
                    zifu[j]=scanner.next().toCharArray();
                }
                String word=scanner.next();
                Yongli ceshi=new Yongli(row,crw,zifu,word);
                arrayList.add(ceshi);
            }
            ArrayList<Integer> result=wordSolu(arrayList);
            for (Integer integer:result) {
                System.out.println(integer);
            }
        }
    }
    public static ArrayList<Integer> wordSolu(ArrayList<Yongli> arrayList){
        ArrayList<Integer> result=new ArrayList<>();
        for (Yongli ceshi:arrayList) {
            int num=0;
            String word=ceshi.word;
            for (int i = 0; i <ceshi.row ; i++) {
                for (int j = 0; j <ceshi.crw ; j++) {
                    if (ceshi.zifu[i][j]==word.charAt(0)){
                        //纵向
                        int k=i+1;int index=1;
                        while (k<i+ceshi.word.length()){
                            if (k<ceshi.row&&ceshi.word.charAt(index++)==ceshi.zifu[k][j])
                                k++;
                            else
                                break;
                        }
                        if (k==i+ceshi.word.length())
                            num++;

                        //横向
                        k=j+1;index=1;
                        while (k<j+ceshi.word.length()){
                            if (k<ceshi.crw&&ceshi.word.charAt(index++)==ceshi.zifu[i][k])
                                k++;
                            else
                                break;
                        }
                        if (k==j+ceshi.word.length())
                            num++;

                        //右下方
                        int l=i+1;k=j+1;index=1;
                        while (k<j+ceshi.word.length()){
                            if (k<ceshi.crw&&l<ceshi.row&&ceshi.word.charAt(index++)==ceshi.zifu[l][k]){
                                k++;l++;
                            }
                            else
                                break;
                        }
                        if (k==j+ceshi.word.length())
                            num++;
                    }
                }
            }
            result.add(num);
        }
        return result;
    }
    static class Yongli{
        int row;
        int crw;
        char[][] zifu;
        String word;

        public Yongli(int row, int crw, char[][] zifu, String word) {
            this.row = row;
            this.crw = crw;
            this.zifu = zifu;
            this.word = word;
        }
    }
}

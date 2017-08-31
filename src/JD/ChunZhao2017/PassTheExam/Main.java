package JD.ChunZhao2017.PassTheExam;

import java.util.Scanner;

/**
 * Created by tzy on 2017/8/31.
 * 小明同学要参加一场考试，考试一共有n道题目，小明必须做对至少60%的题目才能通过考试。
 * 考试结束后，小明估算出每题做对的概率，p1,p2,...,pn。你能帮他算出他通过考试的概率吗？
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            double[] passproba=new double[num];
            double[] noPassProba=new double[num];
            for (int i = 0; i <num ; i++) {
                passproba[i]=(double) (scanner.nextInt()/100);
                noPassProba[i]=1-passproba[i];
            }
            int pass=(int) (num*0.6);
        }
    }
    public double passTheExam(){

        return 0.0;
    }
}

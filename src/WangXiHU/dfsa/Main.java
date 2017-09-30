package WangXiHU.dfsa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/16.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        String[] str=new String[n];
        for (int i = 0; i <n; i++) {
            str[i]=in.next();
        }
        ArrayList<String> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] temp=str[i].split(":");
            StringBuilder sb=new StringBuilder();
            if(Integer.parseInt(temp[0])<0||Integer.parseInt(temp[0])>23){
                sb.append('0');
                sb.append(temp[0].charAt(1));
                sb.append(':');
            }else{
                sb.append(temp[0]);
                sb.append(':');
            }
            if(Integer.parseInt(temp[1])<0||Integer.parseInt(temp[1])>59){
                sb.append('0');
                sb.append(temp[1].charAt(1));
                sb.append(':');
            }else{
                sb.append(temp[1]);
                sb.append(':');
            }
            if(Integer.parseInt(temp[2])<0||Integer.parseInt(temp[2])>59){
                sb.append('0');
                sb.append(temp[2].charAt(1));
            }else{
                sb.append(temp[2]);
            }
            res.add(sb.toString());
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
package XiaoMi.dsf;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine().trim();
            Vector<String> vector=new Vector<>();
            String temp="";
            dfs_String(vector,temp,string,0);
            for (int i = 0; i <vector.size()-1 ; i++) {
                System.out.print(vector.get(i)+" ");
            }
            System.out.println(vector.get(vector.size()-1));
        }
    }
    private static void dfs_String(Vector<String> vector,String temp,String s,int start){
        if (start==s.length()){
            vector.add(temp);
            return;
        }
        if (check1(s,start)){
            temp+=(char)(s.charAt(start)-'1'+'a');
            dfs_String(vector,temp,s,start+1);
            temp=temp.substring(0,temp.length()-1);
        }
        if (check2(s,start)){
            String s2=s.substring(start,start+2);
            int num=Integer.valueOf(s2);
            temp+=(char)(num-1+'a');
            dfs_String(vector,temp,s,start+2);
            temp=temp.substring(0,temp.length()-1);
        }
    }
    private static boolean check1(String s,int start){
        if (start<s.length()&&(s.charAt(start)>='0'&&s.charAt(start)<='9'))
            return true;
        else
            return false;
    }
    private static boolean check2(String s,int start){
        if (start+1<s.length()&&(s.charAt(start)=='1'||(s.charAt(start)=='2'&&s.charAt(start+1)<='6')))
            return true;
        else
            return false;
    }
}

package WanMeiShiJie.QiuZhao2017.TimeInterval;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] str1=sc.nextLine().split(" ");
        String[] str2=sc.nextLine().split(" ");
        String sDate[]=str1[0].split("/");
        String eDdate[]=str2[0].split("/");
        String sTime[]=str1[1].split(":");
        String eTime[]=str2[1].split(":");

        int sYear=Integer.valueOf(sDate[0]);
        int sMon=Integer.valueOf(sDate[1]);
        int sDay=Integer.valueOf(sDate[2]);
        int sHour=Integer.valueOf(sTime[0]);
        int sMinu=Integer.valueOf(sTime[1]);
        int sSec=Integer.valueOf(sTime[2]);
        int eYear=Integer.valueOf(eDdate[0]);
        int eMon=Integer.valueOf(eDdate[1]);
        int eDay=Integer.valueOf(eDdate[2]);
        int eHour=Integer.valueOf(eTime[0]);
        int eMinu=Integer.valueOf(eTime[1]);
        int eSec=Integer.valueOf(eTime[2]);

        int day_diff=day_diff(sYear,sMon,sDay,eYear,eMon,eDay);
        int week_diff=week(sYear,sMon,sDay);
        if(day_diff>0 && eSec>0)
            System.out.print(day_diff+",");
        else if(day_diff==0)
            System.out.print(0+",");
        else if(day_diff>0 && eSec==0){
            System.out.print(day_diff-1+",");
            day_diff-=1;
        }
        if(4-week_diff>0 &&day_diff-(4-week_diff)>=0)
            System.out.print(1);
        else
            System.out.print(day_diff/7);

    }

    public static int week(int y,int m,int d){  //计算当前日期是星期几
        int a=7; // 用来保存计算得到的星期几的整数
        int str_date=0;
        if((m==1)||(m==2))//如果是一月或二月进行换算
        {
            m+=12;
            y--;
        }
        a=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7;   //得到的星期几的整数
        switch (a){
            case 0:
                str_date=1;
                break;
            case 1:
                str_date=2;
                break;
            case 2:
                str_date=3;
                break;
            case 3:
                str_date=4;
                break;
            case 4:
                str_date=5;
                break;
            case 5:
                str_date=6;
                break;
            case 6:
                str_date=7;
                break;
        }
        return str_date;
    }
    public static int day_diff(int year_start, int month_start, int day_start, int year_end, int month_end, int day_end){//计算两个日期差多少天
        int y2, m2, d2;
        int y1, m1, d1;

        m1 = (month_start + 9) % 12;
        y1 = year_start - m1/10;
        d1 = 365*y1 + y1/4 - y1/100 + y1/400 + (m1*306 + 5)/10 + (day_start - 1);

        m2 = (month_end + 9) % 12;
        y2 = year_end - m2/10;
        d2 = 365*y2 + y2/4 - y2/100 + y2/400 + (m2*306 + 5)/10 + (day_end - 1);

        return (d2 - d1);
    }
}

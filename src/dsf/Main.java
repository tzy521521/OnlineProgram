package dsf;

/**
 * Created by tzy on 2017/9/20.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(GetDay(20150817));
    }
    public static int GetDay(int nIime){
        //每个月份的天数
        int[] tian={31,28,31,30,31,30,31,31,30,31,30,31};
        //该月第几天
        int ri=0;
        ri+=nIime%10;
        nIime=nIime/10;
        ri+=10*nIime%10;
        nIime=nIime/10;

        //第几个月
        int yue=0;
        yue+=nIime%10;
        nIime=nIime/10;
        yue+=10*nIime%10;
        nIime=nIime/10;

        //年份
        int nian=nIime;
        int day=0;
        for (int i = 0; i <yue ; i++) {
            day+=tian[i];
        }
        day+=ri;

        //闰年二月份是29天
        if (nian%4==0&&nian%400!=0)
            day++;
        return day;
    }
}

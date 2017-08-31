package JD.ChunZhao2017.AverageOfJinZhi;

import java.util.Scanner;

/**
 * Created by tzy on 2017/8/31.
 * 尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题。现在，她正在玩一个数值变换的游戏。她发现计算机中经常用不同的进制表示同一个数，如十进制数123表达为16进制时只包含两位数7、11（B），用八进制表示时为三位数1、7、3。按不同进制表达时，各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是18和11。
 * 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？
 * 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式。
 * 样例输入5 3
 * 样例输出7/3 2/1
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            int total=0;
            for (int i = 2; i <num ; i++) {
                total+=sumOfbit(num,i);
            }
            int gcd=GCD(total,num-2);
            System.out.println(total/gcd+"/"+(num-2)/gcd);
        }
    }
    public static int sumOfbit(int m,int jz){
        int sum=0;
        while (m!=0){
            sum+=m%jz;
            m=m/jz;
        }
        return sum;
    }
    //化简分数用到了求最大公约数。记住欧几里得求最大公约数
    public static int GCD(int m,int n){
        if (m%n==0)
            return n;
        else
            return GCD(n,m%n);
    }
}

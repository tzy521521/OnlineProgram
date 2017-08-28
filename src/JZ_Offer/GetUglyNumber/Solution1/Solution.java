package JZ_Offer.GetUglyNumber.Solution1;

import java.util.LinkedList;

/**
 * Created by tzy on 2017/8/18.
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 * 分析：如果p是丑数，那么p=2^x * 3^y * 5^z，那么只要赋予x,y,z不同的值就能得到不同的丑数。
 *       如果要顺序找出丑数，要知道下面几个特（fei）点（hua）。
 * 1.那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
 * 2.如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1)
            return 0;
        int array[]=new int[index];
        array[0]=1;
        LinkedList<Integer> q2=new LinkedList<>();q2.add(1*2);
        LinkedList<Integer> q3=new LinkedList<>();q3.add(1*3);
        LinkedList<Integer> q5=new LinkedList<>();q5.add(1*5);
        int m=1;
        while (m<index){
            int q=finMin(q2.peek(),q3.peek(),q5.peek());
            if (q==2){
                int temp=q2.poll();
                array[m++]=temp;
                q2.add(temp*2);q3.add(temp*3);q5.add(temp*5);
            }
            if (q==3){
                int temp=q3.poll();
                array[m++]=temp;
                q3.add(temp*3);q5.add(temp*5);
            }
            if (q==5){
                int temp=q5.poll();
                array[m++]=temp;
                q5.add(temp*5);
            }
        }
        return array[index-1];
    }
    private int finMin(int num2, int num3, int num5) {
        int min = Math.min(num2, Math.min(num3, num5));
        return min == num2 ? 2 : min == num3 ? 3 : 5;
    }
}

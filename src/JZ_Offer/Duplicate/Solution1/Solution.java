package JZ_Offer.Duplicate.Solution1;

/**
 * Created by tzy on 2017/8/18.
 * 数组中第一个重复的数字，需要额外的空间
 */
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null){
            duplication[0]=-1;
            return false;
        }
        boolean[] flag=new boolean[numbers.length];
        for (int num:numbers) {
            if (flag[num]){
                duplication[0]=num;
                return true;
            }
            else
                flag[num]=true ;
        }
        return false;
    }
}

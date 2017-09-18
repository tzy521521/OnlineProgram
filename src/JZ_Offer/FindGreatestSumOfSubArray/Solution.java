package JZ_Offer.FindGreatestSumOfSubArray;

/**
 * Created by tzy on 2017/8/12.
 * start和end表示最后一个和最大的连续子向量的开始和结束的下标
 * 求出所有的和最大的连续子向量，该如何求。
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null||array.length==0)
            return 0;
        int tatal=array[0];
        int max=array[0];
        int stat=0;
        int end=0;
        for (int i = 1; i <array.length ; i++) {
            if (tatal>0)
                tatal=tatal+array[i];
            else{
                tatal=array[i];
                stat=i;
            }
            if (tatal>max){
                max=tatal;
                end=i;
            }
        }
        return max;
    }
}

package JZ_Offer.InversePairs;

/**
 * Created by tzy on 2017/8/12.
 */
public class Solution {
    public int InversePairs(int [] array) {
        if (array==null)
            return 0;
        int[] copy=new int[array.length];
        System.arraycopy(array,0,copy,0,array.length);
        int num=inversePairs(array,copy,0,array.length-1);
        return num;
    }
    private int inversePairs(int[] array,int[] copy,int start,int end){
        if (start==end){
            return 0;
        }

        int lengh=(end-start)/2;
        int left=inversePairs(copy,array,start,start+lengh)%1000000007;
        int rigt=inversePairs(copy,array,start+lengh+1,end)%1000000007;

        //前半段的最后一个数字的下标
        int i=start+lengh;
        //后半段最后一个数字的下表
        int j=end;
        //开始拷贝的位置
        int index=end;

        //数组之间的逆序对。
        int count=0;

        while (i>=start&&j>=start+lengh+1){
            if (array[i]>array[j]){
                copy[index]=array[i];
                index--;
                i--;
                count+=j-(start+lengh);
                if (count>=1000000007)
                    count=count%1000000007;
            }else {
                copy[index]=array[j];
                index--;
                j--;
            }
        }

        for (;i>=start;i--){
            copy[index]=array[i];
            index--;
        }
        for (;j>=start+lengh+1;j--){
            copy[index]=array[j];
            index--;
        }
        return (count+left+rigt)%1000000007;
    }
}

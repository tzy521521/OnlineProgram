package JZ_Offer.FindNumbersWithSum.Solution0;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/3/24.
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int low=0;
        int height=array.length-1;
        ArrayList<Integer> arrayList=new ArrayList<>();
        while (height>low){
            if (array[low]+array[height]>sum)
                height--;
            else if (array[height]+array[low]==sum){
                arrayList.add(array[low]);
                arrayList.add(array[height]);
                break;
            }
            else{
                low++;
            }
        }
        return arrayList;
    }
}

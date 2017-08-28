package JZ_Offer.FindNumbersWithSum.Solution2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tzy on 2017/3/24.
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int low=0;low<array.length-1;low++){
            int temp=sum-array[low];
            int flag=Arrays.binarySearch(array,low+1,array.length,temp);
            if (flag>=0){
                arrayList.add(array[low]);
                arrayList.add(array[flag]);
                break;
            }
        }
        return arrayList;
    }
}

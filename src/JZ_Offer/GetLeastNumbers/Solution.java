package JZ_Offer.GetLeastNumbers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tzy on 2017/3/29.
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer>arrayList=new ArrayList<>();
        Arrays.sort(input);
        if (k>input.length||k<1)
            return arrayList;
        for (int i = 0; i <k ; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }
}

package JZ_Offer.VerifySquenceOfBST;

import java.util.Arrays;

/**
 * Created by tzy on 2017/8/16.
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0)
            return false;
        int[] inOrder= new int[sequence.length];
        System.arraycopy(sequence,0,inOrder,0,inOrder.length);
        Arrays.sort(inOrder);
        int k=0;
        while (k<inOrder.length){
            if (inOrder[k]==sequence[sequence.length-1])
                break;
            else
                k++;
        }
        if (k==0)
            return true;
        int[] left_sequence= new int[k];
        System.arraycopy(sequence,0,left_sequence,0,k);
        Arrays.sort(left_sequence);
        for (int i = 0; i <k ; i++) {
            if (left_sequence[i]!=inOrder[i])
                return false;
        }
        return VerifySquenceOfBST(left_sequence);
    }
}

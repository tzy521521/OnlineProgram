package JZ_Offer.Multiply;

/**
 * Created by tzy on 2017/8/26.
 */
public class Solution {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            //计算下三角连乘
            B[0] = 1;
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }

            //计算上三角
            int temp = 1;
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }
}

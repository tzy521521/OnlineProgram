package JZ_Offer.PrintMatrix;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/8/18.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int [][] matrix={{1, 2, 3, 4},{5, 6, 7, 8} , {9,10, 11, 12} ,{13, 14, 15, 16}};
        ArrayList<Integer>arrayList=solution.printMatrix(matrix);
        System.out.println(arrayList);
    }
}

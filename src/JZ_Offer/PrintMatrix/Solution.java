package JZ_Offer.PrintMatrix;

import java.util.ArrayList;

/**
 * Created by tzy on 2017/8/18.
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int carry=matrix.length;
        int row=matrix[0].length;
        boolean[][] flag =new boolean[carry][row];
        ArrayList<Integer> arrayList=new ArrayList<>();
        int i=0;
        int j=0;
        while (arrayList.size()<(carry*row)){
            while (j<row&&!flag[i][j]){
                int temp=j++;
                arrayList.add(matrix[i][temp]);
                flag[i][temp]=true;
            }
            j--;i++;

            while (i<carry&&!flag[i][j]){
                int temp=i++;
                arrayList.add(matrix[temp][j]);
                flag[temp][j]=true;
            }
            i--;j--;

            while (j>=0&&!flag[i][j]){
                int temp=j--;
                arrayList.add(matrix[i][temp]);
                flag[i][temp]=true;
            }
            j++;i--;

            while (i>=0&&!flag[i][j]){
                int temp=i--;
                arrayList.add(matrix[temp][j]);
                flag[temp][j]=true;
            }
            i++;j++;
        }
        return arrayList;
    }
}

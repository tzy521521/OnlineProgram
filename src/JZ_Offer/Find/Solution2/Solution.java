package JZ_Offer.Find.Solution2;

/**
 * Created by tzy on 2017/3/21.
 */
public class Solution {
    //从数组右上角开始和target比较。
    public boolean Find(int target, int [][] array) {
        int row=0;
        int col=array[0].length-1;
        while (col>=0&&row<array.length){
            if (target>array[row][col])
                row++;
            else if (target<array[row][col])
                col--;
            else
                return true;
        }
        return false;
    }
}

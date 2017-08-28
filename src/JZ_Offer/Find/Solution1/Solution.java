package JZ_Offer.Find.Solution1;

/**
 * Created by tzy on 2017/3/21.
 */
public class Solution {
    //从数组左下角开始和target比较。
    public boolean Find(int target, int [][] array) {
        int row=array.length-1;
        int col=0;
        while (col<array[0].length&&row>=0){
            if (target>array[row][col])
                col++;
            else if (target<array[row][col])
                row--;
            else
                return true;
        }
        return false;
    }
}

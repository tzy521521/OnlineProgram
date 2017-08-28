package JZ_Offer.RectCover.Solution1;

/**
 * Created by tzy on 2017/8/20.
 */
public class Solution {
    public int RectCover(int target) {
        if (target>0){
            int f1=1;
            int f2=2;
            int f3=3;
            if (target==1)
                return f1;
            else if(target==2)
                return f2;
            else if (target==3)
                return f3;
            for (int i=4;i<=target;i++){
                f1=f2;
                f2=f3;
                f3=f1+f2;
            }
            return f3;
        }
        else
            return 0;
    }
}

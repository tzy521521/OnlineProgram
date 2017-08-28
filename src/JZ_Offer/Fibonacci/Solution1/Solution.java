package JZ_Offer.Fibonacci.Solution1;

/**
 * Created by tzy on 2017/3/21.
 */
public class Solution {
    public int Fibonacci1(int n){
        if (n<0)
            return 0;
        int f0=0;
        int f1=1;
        int f2=1;
        if (n==0)
            return f0;
        else if (n==1)
            return f1;
        else if (n==2)
            return f2;
        for (int i=3;i<=n;i++){
            f0=f1;
            f1=f2;
            f2=f0+f1;
        }
        return f2;
    }
}
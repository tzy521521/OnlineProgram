package JZ_Offer.MaxInWindows;

/**
 * Created by tzy on 2017/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] text={2,3,4,2,6,2,5,1};
        System.out.println(solution.maxInWindows(text,3));
    }
}

package JZ_Offer.LeftRotateString.Solution1;

/**
 * Created by tzy on 2017/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String string="abcXYZdef";
        System.out.println(solution.LeftRotateString(string,8));
        System.out.println(solution.LeftRotateString(string,17));
        System.out.println(solution.LeftRotateString(string,9));
        System.out.println(solution.LeftRotateString(string,18));
        System.out.println(solution.LeftRotateString(string,0));
    }
}

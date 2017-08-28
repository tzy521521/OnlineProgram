package JZ_Offer.FirstAppearingOnce;

/**
 * Created by tzy on 2017/8/27.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        String string="google";
        for (int i = 0; i <string.length() ; i++) {
            solution.Insert(string.charAt(i));
        }
        System.out.println(solution.FirstAppearingOnce());
    }
}

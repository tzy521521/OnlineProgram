package JZ_Offer.Match;

/**
 * Created by tzy on 2017/8/18.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.match("bcbbabab".toCharArray(),".*a*a".toCharArray()));
    }
}

package JZ_Offer.ReverseSentence;

/**
 * Created by tzy on 2017/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        String string="student. a am I";
        System.out.println(solution.ReverseSentence(string));

        String string1="   ";
        System.out.println(solution.ReverseSentence(string1));
    }
}

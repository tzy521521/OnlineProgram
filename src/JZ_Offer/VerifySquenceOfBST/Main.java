package JZ_Offer.VerifySquenceOfBST;

/**
 * Created by tzy on 2017/8/17.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] post={5,6,8,10,9,7};
        System.out.println(solution.VerifySquenceOfBST(post));

        int[] post1={9,5,6,8,10,7};
        System.out.println(solution.VerifySquenceOfBST(post1));
    }
}

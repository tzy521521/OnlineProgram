package JZ_Offer.HasPath;

/**
 * Created by tzy on 2017/8/17.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        char[] matrix="abceccdsedee".toCharArray();
        char[] str="abcce".toCharArray();
        System.out.println(solution.hasPath(matrix,3,4,str));
    }
}

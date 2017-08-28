package JZ_Offer.Duplicate.Solution1;

/**
 * Created by tzy on 2017/8/18.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int numbers[]={2,1,3,1,4};
        int [] duplication=new int[1];
        System.out.println(solution.duplicate(numbers,numbers.length,duplication));
        System.out.println(duplication[0]);
    }
}

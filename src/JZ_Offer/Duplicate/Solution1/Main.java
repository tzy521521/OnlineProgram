package JZ_Offer.Duplicate.Solution1;

/**
 * Created by tzy on 2017/8/18.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int numbers[]={0,4,2,1,0};
        int [] duplication=new int[numbers.length];
        System.out.println(solution.duplicate(numbers,numbers.length,duplication));
        System.out.println(duplication[0]);
    }
}

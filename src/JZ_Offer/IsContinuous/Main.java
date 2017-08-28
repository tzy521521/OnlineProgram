package JZ_Offer.IsContinuous;

/**
 * Created by tzy on 2017/8/18.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int [] numbers={1,3,5,0,0};
        System.out.println(solution.isContinuous(numbers));

        int [] numbers1={1,2,3,5,6};
        System.out.println(solution.isContinuous(numbers1));

        int [] numbers2={1,0,0,1,0};
        System.out.println(solution.isContinuous(numbers2));

        int [] numbers3={0,0,0,0,13};
        System.out.println(solution.isContinuous(numbers3));
    }
}

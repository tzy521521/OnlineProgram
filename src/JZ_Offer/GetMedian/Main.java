package JZ_Offer.GetMedian;

/**
 * Created by tzy on 2017/8/23.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.arrayList);
        System.out.println(solution.GetMedian());
        for (int i = 0; i <8 ; i++) {
            solution.Insert((int)(Math.random()*100));
        }
        System.out.println(solution.arrayList);
        System.out.println(solution.GetMedian());
    }
}

package JZ_Offer.ReOrderArray;

/**
 * Created by tzy on 2017/8/27.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] array={1,2,3,4,5,6,7};
        int[]a= solution.reOrderArray(array);
        for (int i:a) {
            System.out.print(i+" ");
        }
    }
}

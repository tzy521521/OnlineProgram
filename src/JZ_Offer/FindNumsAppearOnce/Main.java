package JZ_Offer.FindNumsAppearOnce;

/**
 * Created by tzy on 2017/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

        int[] array={2,0,3,6,3,2,5,5,6,1,4};
        int[] num1=new int[1];
        int[] num2=new int[1];
        solution.FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }
}

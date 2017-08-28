package JZ_Offer.PrintFromTopToBottom;

/**
 * Created by tzy on 2017/8/12.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] element={24,36,48,10,20,21,28,30,0,0,20,0,0,0,0};

        BT bt=new BT(element);
        System.out.println(solution.PrintFromTopToBottom(bt.root));
    }
}

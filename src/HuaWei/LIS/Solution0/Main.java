package HuaWei.LIS.Solution0;

import java.util.Arrays;

/**
 * Created by tzy on 2017/8/29.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] students={186, 186, 150, 200, 160, 130, 197, 200};
        System.out.println(solution.length_LIS(students));
        System.out.println(Arrays.toString(solution.LIS(students)));
        System.out.println(solution.seqLISs(students));
    }
}

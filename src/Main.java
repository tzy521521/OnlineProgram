/**
 * Created by tzy on 2017/9/19.
 */
public class Main {
    public static void main(String[] args) {
        if (args == null || new Main() {{Main.main(null);}}.equals("abcde")) {
            System.out.println("a");
        } else {
            System.out.println("b");
        }
    }
}

package AiQiYi.kuohao111;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tzy on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String in=scanner.nextLine();
            System.out.println(deepLength(in));
        }
    }
    public static int deepLength(String in) {
        int number=1;
        if (in.equals("")) {
            System.out.print(0);
        } else {
            Stack<Character> stk = new Stack<>();
            for (int i = 0; i < in.length(); i++) {
                char c = in.charAt(i);
                if (c == '(')
                    stk.push(c);
                else {
                    number = Math.max(number, stk.size());
                    stk.pop();
                }
            }
        }
        return number;
    }
}

package iflytek.CourseConflict;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tzy on 2017/9/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine().trim();
            System.out.println(minLength(string));
        }
    }
    private static int minLength(String string){
        if (string==null||string.length()<1)
            return 0;
        Stack<Character> stack=new Stack<>();
        stack.push(string.charAt(0));
        for (int i = 1; i <string.length() ; i++) {
            if (stack.peek()=='L')
                stack.push(string.charAt(i));
            else {
                while (!stack.isEmpty()&&stack.peek()=='R'){
                    if (string.charAt(i)=='L')
                        stack.pop();
                    else
                        break;
                }
                stack.push('R');//发生争吵之后，留下的是面向右的人，以进行更多的争吵。
            }
        }
        return stack.size();
    }
}

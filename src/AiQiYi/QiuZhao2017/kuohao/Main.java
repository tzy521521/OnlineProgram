package AiQiYi.QiuZhao2017.kuohao;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tzy on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            System.out.println(deepLength(s));
        }
    }
    private static int deepLength(String string){//string 必须是合法的括号序列。
        if (string==null||string.length()<1)
            return 0;
        Stack<Character> stack=new Stack<>();
        stack.push(string.charAt(0));
        int max=0;
        for (int i = 1; i <string.length() ; i++) {
            if (string.charAt(i)==')'){
                max=Math.max(max,stack.size());
                stack.pop();
            }
            else
                stack.push(string.charAt(i));
        }
        return max;
    }
}

package JD.QiuZhao2017.Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tzy on 2017/9/8.
 * 没有全部通过。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            System.out.println(total(string));
        }
    }
    public static int total(String string){
        Stack<Character> stack=new Stack<>();
        ArrayList<Integer> arrayList=new ArrayList<>();
        int index=0;
        stack.push(string.charAt(index++));
        while (!stack.isEmpty()&&index<string.length()){
            if (string.charAt(index++)=='(')
                stack.push('(');
            else {
                arrayList.add(stack.size());
                stack.pop();
            }
        }
        int total=1;
        for (Integer integer:arrayList) {
            total*=integer;
        }
        return total;
    }
}

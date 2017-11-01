package WanMeiShiJie.QiuZhao2017.minAndMaxStack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tzy on 2017/11/1.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Main main=new Main();
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            for (int i = 0; i <n ; i++) {
                main.push(scanner.nextInt());
            }
            main.pop();
            System.out.print(main.max());
            System.out.print(',');
            System.out.print(main.min());
        }
    }
    Integer min=Integer.MAX_VALUE;
    Integer max=Integer.MIN_VALUE;
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    Stack<Integer> maxStack=new Stack<>();
    public void  push(int data){
        stack.push(data);
        if (data<min)
            min=data;
        if (data>max)
            max=data;
        minStack.push(min);
        maxStack.push(max);
    }
    public void pop(){
        stack.pop();
        minStack.pop();
        maxStack.pop();
    }
    public int min(){
        return minStack.peek();
    }
    public int max(){
        return maxStack.peek();
    }
}

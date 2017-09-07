package JinRiTouTiao.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tzy on 2017/9/5.
 * 头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队。
 *每个出题人都出了一些有趣的题目，而我们现在想把这些题目组合成若干场考试出来。
 * 在选题之前，我们对题目进行了盲审，并定出了每道题的难度系数。一场考试包含3道开放性题目，
 * 假设他们的难度从小到大分别为a, b, c，我们希望这3道题能满足下列条件：
 * a＜= b＜= c；b - a＜= 10；c - b＜= 10
 * 所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），
 * 然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求。
 * 然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            ArrayList<Integer> arrayList=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                arrayList.add(scanner.nextInt());
            }
            System.out.println(relNums(arrayList));
        }
    }
    public static int relNums(ArrayList<Integer> arrayList){
        if (arrayList==null||arrayList.size()<1)
            return 3;
        Collections.sort(arrayList);
        Stack<ArrayList<Integer>> stack=new Stack<>();
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arrayList.get(0));
        stack.push(temp);
        for (int i = 1; i <arrayList.size() ; i++) {
            if (arrayList.get(i)-arrayList.get(i-1)<=10)
               stack.peek().add(arrayList.get(i));
            else {
                ArrayList<Integer> temp0=new ArrayList<>();
                temp0.add(arrayList.get(i));
                stack.push(temp0);
            }
        }
        int num=0;
        for (ArrayList<Integer> temp1:stack) {
            if (temp1.size()%3!=0){
                num+=3-temp1.size()%3;
            }
        }
        return num;
    }
}

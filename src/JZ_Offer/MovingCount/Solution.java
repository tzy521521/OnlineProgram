package JZ_Offer.MovingCount;

import java.util.Stack;

/**
 * Created by tzy on 2017/8/17.
 */
public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] maxt=new boolean[rows][cols];
        if (threshold<0)
            return 0;
        Node node=new Node(0,0);
        return movingCount(maxt,node,threshold);
    }
    //从方格开始进行广度优先遍历
    private int movingCount(boolean[][] maxt, Node node,int threshold ) {
        Stack<Node> stack=new Stack<>();
        stack.push(node);
        maxt[node.i][node.j]=true;
        int num=0;
        while (!stack.isEmpty()){
            Node temp=stack.pop();
            num++;
            //判断方格的左边方格是否可以进入。
            if (temp.i+1<maxt.length&&!maxt[temp.i+1][temp.j]){
                int sum=total(temp.i+1)+total(temp.j);
                if (sum<=threshold){
                    stack.push(new Node(temp.i+1,temp.j));
                    maxt[temp.i+1][temp.j]=true;
                }
            }
            //判断方格的右边方格是否可以进入。
            if (temp.i-1>=0&&!maxt[temp.i-1][temp.j]){
                int sum=total(temp.i-1)+total(temp.j);
                if (sum<=threshold){
                    stack.push(new Node(temp.i-1,temp.j));
                    maxt[temp.i-1][temp.j]=true;
                }
            }
            //判断方格的上边方格是否可以进入。
            if (temp.j+1<maxt[0].length&&!maxt[temp.i][temp.j+1]){
                int sum=total(temp.i)+total(temp.j+1);
                if (sum<=threshold){
                    stack.push(new Node(temp.i,temp.j+1));
                    maxt[temp.i][temp.j+1]=true;
                }
            }
            //判断方格的下边方格是否可以进入。
            if (temp.j-1>=0&&!maxt[temp.i][temp.j-1]){
                int sum=total(temp.i)+total(temp.j-1);
                if (sum<=threshold){
                    stack.push(new Node(temp.i,temp.j-1));
                    maxt[temp.i][temp.j-1]=true;
                }
            }
        }
        return num;
    }
    //数位之和
    private int total(int num){
        int sum=0;
        while (num!=0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
    //方格。
    public static class Node{
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

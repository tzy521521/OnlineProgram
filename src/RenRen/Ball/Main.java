package RenRen.Ball;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tzy on 2017/4/28.
 * 面试
 * 矩阵的中的方格的数字表示地势的高低，小球放在任意一个格子里，可以向和他地势相等和低的格子滚动。
 * 小球是否可以滚到边界。
 * 如果可以，如何输出一条或者多条路径？
 */
public class Main {
    private ArrayList<Node> arrayList=new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Please Input Matrix's row and column");
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int[][] matrix=new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                matrix[i][j]=(int)(Math.random()*100);
            }
        }
        System.out.println("=========The Matrix is=============");
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.printf("%-4d",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("Please Input the current position of the ball, row<"+matrix.length+", column<"+matrix[0].length);
        while (scanner.hasNext()){
            int row=scanner.nextInt();
            int column=scanner.nextInt();
            System.out.println("The ball can roll out of the boundary? "+isGun(matrix,row,column));
            System.out.println("Test again:Please Input the current position of the ball, row<"+matrix.length+" column< "+matrix[0].length);
        }
    }
    public static boolean isGun(int[][] matrix,int row ,int column){
        if (matrix==null||matrix.length==0)
            return false;
        if (row==0||row==matrix.length-1||column==0||column==matrix[0].length-1)
            return true;
        boolean[][] flag=new boolean[matrix.length][matrix[0].length];
        Stack<Node>stack =new Stack<>();
        Node tem=new Node(row,column,matrix[row][column]);
        stack.push(tem);
        flag[tem.row][tem.colunm]=true;

        while (!stack.isEmpty()){
            tem=stack.pop();
            if (tem.row+1<matrix.length&&!flag[tem.row+1][tem.colunm]){
                if (tem.val>=matrix[tem.row+1][tem.colunm]) {
                    if (tem.row + 1 == matrix.length-1)
                        return true;
                    else{
                        stack.push(new Node(tem.row + 1, tem.colunm, matrix[tem.row + 1][tem.colunm]));
                        flag[tem.row+1][tem.colunm]=true;
                    }
                }
            }
            if (tem.row-1>=0&&!flag[tem.row-1][tem.colunm]){
                if (tem.val>=matrix[tem.row-1][tem.colunm]) {
                    if (tem.row - 1 == 0)
                        return true;
                    else{
                        stack.push(new Node(tem.row - 1, tem.colunm, matrix[tem.row - 1][tem.colunm]));
                        flag[tem.row - 1][tem.colunm]=true;
                    }

                }
            }
            if (tem.colunm+1<matrix[0].length&&!flag[tem.row][tem.colunm+1]){
                if (tem.val>=matrix[tem.row][tem.colunm+1]) {
                    if (tem.colunm+1 == matrix[0].length-1)
                        return true;
                    else {
                        stack.push(new Node(row , tem.colunm+1, matrix[tem.row][tem.colunm+1]));
                        flag[tem.row][tem.colunm+1]=true;
                    }
                }
            }
            if (tem.colunm-1>=0&&flag[tem.row][tem.colunm-1]){
                if (tem.val>=matrix[tem.row][tem.colunm-1]) {
                    if (tem.colunm-1 == 0)
                        return true;
                    else{
                        stack.push(new Node(row, tem.colunm-1, matrix[tem.row][tem.colunm-1]));
                        flag[tem.row][tem.colunm-1]=true;
                    }
                }
            }
        }
        return false;
    }
    public static class Node{
        private int row;
        private int colunm;
        private int val;

        public Node(int row, int colunm, int val) {
            this.row = row;
            this.colunm = colunm;
            this.val = val;
        }

        public int getRow() {
            return row;
        }

        public int getColunm() {
            return colunm;
        }

        public int getVal() {
            return val;
        }
    }
}


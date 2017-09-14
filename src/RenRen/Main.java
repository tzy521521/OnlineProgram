package RenRen;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int k=scanner.nextInt();
            int[][] martix=new int[n][m];
            ArrayList<Node> isTrueTro=new ArrayList<>();
            for (int i = 0; i <k ; i++) {
                int x=scanner.nextInt();
                int y=scanner.nextInt();
                martix[x-1][y-1]=1;
                if (!(x==n&&y==m))
                    isTrueTro.add(new Node(x-1,y-1));
            }
            martix[n-1][m-1]=1;
            isTrueTro.add(new Node(n-1,m-1));
            ArrayList<ArrayList<Character>> resust=minLength(isTrueTro,martix,n,m);
            for (ArrayList<Character> a:resust) {
                System.out.print(a.get(0));
            }
        }
    }
    public static ArrayList<ArrayList<Character>> minLength(ArrayList<Node> isTrueTro,int[][]martix,int n,int m){
        ArrayList<ArrayList<Character>> arrayLists=new ArrayList<>();
        ArrayList<Node> arrayList=new ArrayList<>();
        arrayList.add(new Node(0,0));
        for (Node istrue:isTrueTro) {
            while (!arrayList.isEmpty()){
                ArrayList<Node> temp = new ArrayList<>();
                ArrayList<Character> tempCha=new ArrayList<>();
                for (Node node:arrayList) {
                    //向下走
                    if (node.i+1<n){
                        if (martix[node.i+1][node.i+1]==0){
                            temp.add(new Node(node.i+1,node.j));
                            martix[node.i+1][node.j]=2;
                            tempCha.add('D');
                        }
                         if (martix[node.i+1][node.i]==1){
                            temp.add(new Node(node.i+1,node.j));
                            tempCha.add('D');
                            break;
                        }
                    }
                    //向右走
                    if (node.j+1<m){
                        if (martix[node.i][node.i+1]==0){
                            temp.add(new Node(node.i,node.j+1));
                            martix[node.i][node.j+1]=2;
                            tempCha.add('R');
                        }
                        if (martix[node.i][node.i+1]==1){
                            temp.add(new Node(node.i,node.j+1));
                            tempCha.add('R');
                            break;
                        }
                    }
                }
                arrayList=temp;
                arrayLists.add(tempCha);
            }
        }
        return arrayLists;
    }
    static class Node{
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

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
            Node start=new Node(scanner.nextInt(),scanner.nextInt());
            Node end=new Node(scanner.nextInt(),scanner.nextInt());
            int[][] martix=new int[n][m];
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <m ; j++) {
                    martix[i][j]=scanner.nextInt();
                }
            }
            System.out.println(isGoOut(martix,n,m,start,end));
        }
    }
    public static int isGoOut(int[][] matix,int n,int m,Node start,Node end){
        boolean[][] isVisited=new boolean[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                int flag=matix[i][j];
                if (flag!=0){
                    isVisited[i][j]=true;
                    for (int k = 1; k <flag ; k++) {
                        if (i+k<n)
                            isVisited[i+k][j]=true;
                        if (i-k>=0)
                            isVisited[i-k][j]=true;
                        if (j+k<m)
                            isVisited[i][j+k]=true;
                        if (j-k>=0)
                            isVisited[i][j-k]=true;
                    }
                }
            }
        }
        if (isVisited[end.i][end.j]||isVisited[start.i][start.j])//????
            return -1;
        isVisited[start.i][start.j]=true;
        int leng=0;
        ArrayList<Node> arrayList=new ArrayList<>();
        arrayList.add(start);
        while (!arrayList.isEmpty()){
            ArrayList<Node> temp = new ArrayList<>();
            for (Node node:arrayList) {
                //
                if (node.i+1<n){
                    if (!isVisited[node.i+1][node.j]){
                        if (node.i+1==end.i&&node.j==end.j)
                            return leng+1;
                        else {
                            isVisited[node.i+1][node.j]=true;
                            temp.add(new Node(node.i+1,node.j));
                        }
                    }
                }

                //
                if (node.i-1>=0){
                    if (node.i-1==end.i&&node.j==end.j)
                        return leng+1;
                    else{
                        if (!isVisited[node.i-1][node.j]){
                            isVisited[node.i-1][node.j]=true;
                            temp.add(new Node(node.i-1,node.j));
                        }
                    }
                }
                //
                if (node.j+1<m){
                    if (node.i==end.i&&node.j+1==end.j)
                        return leng+1;
                    else{
                        if (!isVisited[node.i][node.j+1]){
                            isVisited[node.i][node.j+1]=true;
                            temp.add(new Node(node.i,node.j+1));
                        }
                    }
                }
                //
                if (node.j-1>=0){
                    if (node.i==end.i&&node.j-1==end.j)
                        return leng+1;
                    else{
                        if (!isVisited[node.i][node.j-1]){
                            isVisited[node.i][node.j-1]=true;
                            temp.add(new Node(node.i,node.j-1));
                        }
                    }
                }
            }
            arrayList=temp;
            leng++;
        }
        return -1;
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

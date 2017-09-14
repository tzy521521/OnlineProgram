package QuNaEr.QiuZhao2017.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/14.
 */
public class Main {
    private static int max=-1;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int r=scanner.nextInt();
            //关系
            ArrayList<String[]> arrayList=new ArrayList<>();
            //人物
            HashSet<String> hashSet=new HashSet<>();
            for (int i = 0; i <r ; i++) {
                String[] rels=new String[2];
                rels[0]=scanner.next();hashSet.add(rels[0]);
                rels[1]=scanner.next();hashSet.add(rels[1]);
                arrayList.add(rels);
            }
            ArrayList<String> name=new ArrayList<>(hashSet);
            System.out.println(maxRelse(name,arrayList));
        }
    }
    public static int maxRelse(ArrayList<String> name,ArrayList<String[]> arrayList){
        //邻接点链表。
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
        for (int i = 0; i <name.size() ; i++) {
            ArrayList<Integer> tem=new ArrayList<>();
            arrayLists.add(tem);
        }
        for (String[] res:arrayList) {
            int index=name.indexOf(res[0]);
            arrayLists.get(index).add(name.indexOf(res[1]));
            int index1=name.indexOf(res[1]);
            arrayLists.get(index1).add(name.indexOf(res[0]));
        }
        for (int i = 0; i <name.size() ; i++) {
            boolean isvisted[]=new  boolean[arrayLists.size()];
            dfs(arrayLists,isvisted,i,-1);
        }
        return max;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> arrayLists,boolean[] isvisted,int index,int length){
        isvisted[index]=true;
        int i=0;
        while (i <arrayLists.get(index).size()){
            if (!isvisted[arrayLists.get(index).get(i)]) {
                length++;
                if (length>max)
                    max=length;
                dfs(arrayLists,isvisted,arrayLists.get(index).get(i),length);
            }
            i++;
            if (i==arrayLists.get(index).size())
                length--;
        }

    }
}

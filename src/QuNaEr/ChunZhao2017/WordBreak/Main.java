package QuNaEr.ChunZhao2017.WordBreak;

import java.util.*;

/**
 * Created by tzy on 2017/4/2.
 * 有一个单词列表，一个初始单词和一个最终单词，初始单词需要通过单词列表逐步变换到最终单词，求变换所需的最短变换路径长度。
 * 变换规则：每次只能变动1个字母（不可交换位置，如：从abc变成cba属于变动了2个字母），每次变换只能从单词列表中选取。
 * 例如：初始单词hot，最终单词dog，单词列表[got, dot, god, dog, lot, log]，最短变换路径为[hot,dot,dog]，最短变换路径长度为3。
 * 注：单词列表中包含最终单词，不包含初始单词；列表中每一项单词长度与初始单词、最终单词相同；列表中单词不重复；所有字母均为小写。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            ArrayList<String>arrayList=new ArrayList<>();

            String beginWord=scanner.nextLine();
            arrayList.add(beginWord);
            String endWord=scanner.nextLine();
            String[] list=scanner.nextLine().split("\\s");
            Collections.addAll(arrayList,list);

            System.out.println(ladderLength(beginWord,endWord,arrayList));
            System.out.println(ladderLength1(beginWord,endWord,arrayList));
        }
    }
    //建立邻接点线性表
    public static ArrayList<String>[] adjacencyList(ArrayList<String> arrayList){
        ArrayList<String>[] neighbors=new ArrayList[arrayList.size()];
        for (int i = 0; i <arrayList.size() ; i++) {
            //这个步骤不能忘
            neighbors[i]=new ArrayList<>();
            String temp=arrayList.get(i);
            for (int j = 0; j <arrayList.size() ; j++) {
                String current=arrayList.get(j);
                if (isOnceBreak(temp,current))
                    neighbors[i].add(current);
            }
        }
        return neighbors;
    }
    //判断两个单词是否只相差一个字母。
    private static boolean isOnceBreak(String string,String current){
        if (string.compareTo(current)!=0){
            for (int i = 0; i <string.length() ; i++) {
                char[] chars=string.toCharArray();
                for (char start='a';start<='z';start++) {
                    chars[i]=start;
                    String newtemp=new String(chars);
                    if (current.compareTo(newtemp)==0)
                        return true;
                }
            }
        }
        return false;
    }
    //利用广度搜索查找最短路径
    public static int ladderLength(String beginWord,String endWord,ArrayList arrayList){
        ArrayList<String>[] neighbors=adjacencyList(arrayList);
        int len = 1;//初始长度为1
        ArrayList<String> beginSet = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        visited.add(beginWord);
        while (!beginSet.isEmpty()) {
            ArrayList<String> temp = new ArrayList<>();
            for (String word : beginSet) {
                int k=arrayList.indexOf(word);
                for (String current:neighbors[k]) {
                    if (current.compareTo(endWord)==0)
                        return len + 1;
                    if (!visited.contains(current)) {
                        temp.add(current);
                        visited.add(current);
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return -1;
    }
    //利用双端广度搜索查找最短路径。。。
    public static int ladderLength1(String beginWord,String endWord,ArrayList arrayList){
        ArrayList<String>[] neighbors=adjacencyList(arrayList);
        Set<String> beginSet = new HashSet<>(),endSet = new HashSet<>();
        int len = 1;
        HashSet<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty()&&!endSet.isEmpty()) {
            //双端遍历，使得遍历的路径少。
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                int k=arrayList.indexOf(word);
                for (String current:neighbors[k]) {
                    if (endSet.contains(current))
                        return len + 1;
                    if (!visited.contains(current)) {
                        temp.add(current);
                        visited.add(current);
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return -1;
    }
}

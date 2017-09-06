package QuNaEr.ChunZhao2017.WordBreak1;

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
            ArrayList<String>[] neighbors=AdjacencyList(arrayList);

            for (ArrayList<String> temp:neighbors) {
                System.out.println(temp);
            }

            ArrayList<String> bfsOrder=BFS(beginWord,arrayList,neighbors);
            System.out.println("广度优先搜索~~~");
            System.out.println(bfsOrder);

            ArrayList<String> dfsOrder=DFS(beginWord,arrayList,neighbors);
            System.out.println("深度优先搜索~~~");
            System.out.println(dfsOrder);
            ArrayList<String> dfsOrder1=DFS_1(beginWord,arrayList,neighbors);
            System.out.println("深度优先搜索~~~");
            System.out.println(dfsOrder1);

            System.out.println("变换长度");
            System.out.println(ladderLength(beginWord,endWord,arrayList,neighbors));
            System.out.println(ladderLength1(beginWord,endWord,arrayList,neighbors));

            List<List<String>> lists=new ArrayList<>(findLadders(beginWord,endWord,arrayList,neighbors));
            for (List<String> a:lists) {
                System.out.println(a);
            }

        }
    }

    //建立邻接点线性表
    public static ArrayList<String>[] AdjacencyList(ArrayList<String> arrayList){
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

    //深度优先搜索非递归算法。
    public static ArrayList<String> DFS_1(String beginWord,ArrayList<String>arrayList,ArrayList<String>[] neighbors){
        ArrayList<String> searchOrder=new ArrayList<>();
        Stack<String> stack=new Stack<>();
        stack.push(beginWord);//~~~~~~~~~~~
        searchOrder.add(beginWord);//~~~~~~~~~~~~~
        while (!stack.isEmpty()){
            String temp=stack.peek();
            int k=arrayList.indexOf(temp);
            for (String str:neighbors[k]) {
                if (searchOrder.contains(str)){
                    if (str==neighbors[k].get(neighbors[k].size()-1)){
                        stack.pop();
                        break;
                    }
                    continue;
                }else {
                    searchOrder.add(str);
                    stack.push(str);
                    break;
                }
            }
        }
        return searchOrder;
    }
    //深度优先搜索递归算法。
    public static ArrayList<String> DFS(String beginWord,ArrayList<String>arrayList,ArrayList<String>[] neighbors){
        ArrayList<String> searchOrder=new ArrayList<>();
        searchOrder.add(beginWord);//~~~~~~~~~~~
        DFS(beginWord,arrayList,neighbors,searchOrder);
       return searchOrder;
    }
    public static void DFS(String beginWord,ArrayList<String>arrayList,ArrayList<String>[] neighbors,ArrayList<String> searchOrder){
        int k=arrayList.indexOf(beginWord);
        for (String str:neighbors[k]) {
            if (searchOrder.contains(str))
                continue;
            else{
                searchOrder.add(str);
                DFS(str,arrayList,neighbors,searchOrder);
            }
        }
    }

    //广度优先搜索。
    public static ArrayList<String> BFS(String beginWord,ArrayList arrayList,ArrayList<String>[] neighbors){
        int k=arrayList.indexOf(beginWord);
        ArrayList<String> order=new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);//~~~~~~~~~~~~~~
        order.add(beginWord);//~~~~~~~~~~~~~~
        for (String str:neighbors[k]) {
            queue.offer(str);
            order.add(str);
        }
        while (!queue.isEmpty()){
            String temp=queue.poll();
            int j=arrayList.indexOf(temp);
            for (String current:neighbors[j]) {
                if (order.contains(current))
                    continue;
                else
                    order.add(current);
            }
        }
        return order;
    }

    //利用广度搜索查找最短路径
    public static int ladderLength(String beginWord,String endWord,ArrayList arrayList,ArrayList<String>[] neighbors){
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
    public static int ladderLength1(String beginWord,String endWord,ArrayList arrayList,ArrayList<String>[] neighbors){
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
    //所有变换最短路径。
    public static List<List<String>> findLadders(String start, String end, ArrayList<String> arrayList,ArrayList<String>[] neighbors) {
        List<List<String>> results = new ArrayList<List<String>>();
        // instead of storing words we are at, we store the paths.
        Deque<List<String>> paths = new LinkedList<List<String>>();
        List<String> path0 = new LinkedList<String>();
        path0.add(start);
        paths.add(path0);
        // if we found a path ending at 'end', we will set lastLevel,
        // use this data to stop iterating further.
        int level = 1, lastLevel = Integer.MAX_VALUE;
        while (!paths.isEmpty()) {
            List<String> path = paths.pollFirst();
            if (path.size() > level) {
                level = path.size();
                if (level > lastLevel)
                    break; // stop and return
            }
            //  try to find next word to reach, continuing from the path
            String last = path.get(level - 1);
            int k=arrayList.indexOf(last);
            //很关键哦~~~
            neighbors[k].remove(path);
            for (String next:neighbors[k]) {
                List<String> nextPath = new LinkedList<String>(path);
                nextPath.add(next);
                if (next.equals(end)) {
                    results.add(nextPath);
                    lastLevel = level; // curr level is the last level
                } else
                    paths.addLast(nextPath);
            }
        }
        return results;
    }
}

package ShiTiGu.StringBreak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tzy on 2017/8/31.
 * 试题广场出现超过内存限制。
 */
public class Change {
    public int countChanges(String[] dic, int n, String s, String t) {
        ArrayList<String> arrayList= new ArrayList<>();
        Collections.addAll(arrayList,dic);
        return ladderLength(s,t,arrayList);
    }
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
    //利用双端广度搜索查找最短路径。。。
    public static int ladderLength(String beginWord,String endWord,ArrayList arrayList){
        ArrayList<String>[] neighbors=adjacencyList(arrayList);
        Set<String> beginSet = new HashSet<>(),endSet = new HashSet<>();
        int len = 0;
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

package U51.MaxCountWord;

import java.util.Scanner;

/**
 * Created by tzy on 2017/10/18
 * n个小写字符串中出现次数最多的字符串.(如果存在多个，按照字典顺序输出最小的那个。)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Main trie = new Main();
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            for (int i = 0; i <n ; i++) {
                String string=scanner.next().trim();
                trie.addWord(string);
            }
            System.out.println(trie.maxCountWord());
        }
    }
    private TrieNode root = new TrieNode();// 字典树的根节点
    private int max;// 统计出现的最大次数
    private String maxWord;// 出现最大次数的字符串
    // 返回出现次数最大的单词
    public String maxCountWord() {
        return maxWord;
    }
    // 向字典树中添加单词
    public void addWord(String word) {
        addWord(root, word, word);// 第二个word是个冗余参数，为了记录增加的单词
    }
    private void addWord(TrieNode vertex, String word, String wordcount) {
        if (word.length() == 0) {
            vertex.words++;
            if (max <=vertex.words) {
                max = vertex.words;
                maxWord = wordcount;
            }
        } else {
            char c = word.charAt(0);
            c = Character.toLowerCase(c);
            int index = c -'a';
            if (vertex.edges[index] == null) { // 构建节点的路径
                vertex.edges[index] = new TrieNode();
            }
            addWord(vertex.edges[index], word.substring(1), wordcount);
        }
    }

    protected class TrieNode {
        protected int words;// 统计从根到该节点的单词出现的个数
        protected TrieNode[] edges;// 存放该节点的子节点

        public TrieNode() {
            this.words = 0;
            edges = new TrieNode[26];// 题目对于字符没有做出限制，这里默认全是小写字母
            for (int i = 0; i < edges.length; i++) {//？？有必要吗？？？？？？？？？？？？？？？？
                edges[i] = null;
            }
        }
    }
}

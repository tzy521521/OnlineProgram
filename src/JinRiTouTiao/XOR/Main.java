package JinRiTouTiao.XOR;

import java.util.Scanner;

/**
 * Created by tzy on 2017/9/8.
 * 给定整数m以及n个数字A1, A2, …, An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果。请求出这些结果中大于m的有多少个。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[] a=new int[n];
            for (int i = 0; i <n ; i++) {
                a[i]=scanner.nextInt();
            }
            System.out.println(solve(a,m));
        }
    }
    public static long solve(int[] a,int m){
        TrieTree trieTree=buildTrieTree(a);
        long result=0;
        for (int num:a) {
            result+=queryTrieTree(trieTree,num,m,31);
        }
        return result/2;
    }
    private static long queryTrieTree(TrieTree root, int a, int m, int index){
        if (root==null)
            return 0;
        TrieTree current=root;
        for (int i = index; i >=0 ; i--) {
            //异或的结果从高处开始比较？
            int aDigit=(a>>i)&1;
            int mDigit=(m>>i)&1;
            if (aDigit==1&&mDigit==1){
                //字典中第i位为1，异或结果为0，(因此两个数的异或结果)小于mDigit，不用理会；
                //字典中第i位为0，异或结果为1，(因此两个数的异或结果)大于等于mDigit，需要继续搜索更低位。
                if (current.next[0]==null)
                    //不存在第i位为0的二进制数。
                    return 0;
                else
                    current=current.next[0];
            }else if (aDigit==0&&mDigit==1){
                //字典中第i位为0，异或结果为0，(因此两个数的异或结果)小于mDigit，不用理会；
                //字典中第i位为1，异或结果为1，(因此两个数的异或结果)大于等于mDigit，需要继续搜索更低位。
                if (current.next[1]==null)
                    //不存在第i位为1的二进制数。
                    return 0;
                else
                    current=current.next[1];
            }else if (aDigit==1&&mDigit==0){
                //字典中第k位为0，异或结果为1，与对应分支所有数异或，结果都会大于m，
                long q=(current.next[0]==null?0:current.next[0].count);
                //第k位为1，异或结果为0，递归获得结果；
                long p=queryTrieTree(current.next[1],a,m,i-1);
                return p+q;
            }else {//aDigit=0， mDigit=0时，
                // 字典中第k位为1，异或结果为1，与对应分支所有数异或，结果都会大于m，
                int q=(current.next[1]==null?0:current.next[1].count);
                //第k位为0，异或结果为0，递归获得结果；
                long p=queryTrieTree(current.next[0],a,m,i-1);
                return p+q;
            }
        }
        return 0;
    }
    private static TrieTree buildTrieTree(int[] a){
        //根结点。
        TrieTree trieTree=new TrieTree(-1);
        for (int i = 0; i <a.length ; i++) {
            TrieTree currnet=trieTree;
            for (int j = 31; j >=0 ; j--) {//先存放高位数字比如数字5，二进制为0101，则存放顺序是0,1,0,1
                //求解对应第i位置处二进制数字是0还是1
                int digit=(a[i]>>j)&1;
                if (currnet.next[digit]==null){
                    currnet.next[digit]=new TrieTree(digit);
                }
                currnet=currnet.next[digit];
                currnet.count++;
            }
        }
        return trieTree;
    }
    //存放所有数字的二进制的形式的trie树
    private static class TrieTree{
        //存放孩子结点,指向0或者只想1。
        TrieTree[] next = new TrieTree[2];
        //此处包含的数字0，或者1的个数
        int count=0;
        //除了根节点的是-1外，其他都是0或者1;
        int digit;
        public TrieTree(int digit) {
            this.digit = digit;
        }
    }
}

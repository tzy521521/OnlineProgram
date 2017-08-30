package QiHu360.ChunZhao2017.EvenString;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by tzy on 2017/3/30.
 * 一个字符串S是偶串当且仅当S中的每一个字符都出现了偶数次。如字符串”aabccb”是一个偶串，因为字符a,b,c都出现了两次。而字符串”abbcc”不是偶串，因为字符a出现了一次。
 * 现在给出一个长度为n的字符串T=t1,t2,t3,…,tn。字符串的子串为其中任意连续一段。T长度为1的子串有n个，长度为2的子串有n-1个，以此类推，T一共有n(n+1)/2个子串。给定T，你能算出它有多少个子串是偶串吗？
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String T = sc.next();
            int count = 0;//记录总的偶串数目
            int gi = 0; //gi是用低26bit（int是32bit）表示下标为[0,i]的子串所拥分别有的字母是偶数个（0）还是奇数个（1）。
            Map<Integer,Integer> map = new HashMap<Integer,Integer>(); //保存每个gi出现次数
            map.put(0, 1);//gi为0，表示所有的字母都出现偶数次，是1个偶串，所以赋初值1
            for(int i=0; i<T.length(); i++){
                int x = T.charAt(i) - 'a'; //求得新加入的这个字符的bit位置
                gi ^= (1 << x);  //求加入这个字符后，原来的gi拥有字母个数的奇偶性。如果异或后是0，表示加入该字符后有偶数个字母，反正是奇数个。
                if(map.containsKey(gi)){
                    count += map.get(gi);//g0,g1,g2...g(i-1)和gi相等的，都可以得到一个偶串。有多个少个相等，就有多少个偶串。
                    map.put(gi, map.get(gi)+1); //增加1
                }else{
                    map.put(gi, 1);
                }
            }
            System.out.println(count);
        }
    }
}

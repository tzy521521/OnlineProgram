package iQIYI.QiuZhao2017_2.ValueOfString.Soution1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tzy on 2017/10/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int num = Integer.parseInt(sc.nextLine());
            List<Temp> list = new LinkedList<Temp>();
            char[] chars = new char[127];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                chars[ch]++;
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0) {
                    Temp t = new Temp(String.valueOf(i).charAt(0), chars[i]);
                    list.add(t);
                }
            }
            Collections.sort(list);
            while (num > 0) {
                list.get(0).count--;
                num--;
                Collections.sort(list);
            }
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                res += list.get(i).getCount() * list.get(i).getCount();
            }
            System.out.println(res);
        }
    }
}

class Temp implements Comparable<Temp> {
    Character ch;
    int count;

    public int compareTo(Temp o) {
        return o.count - this.count;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Temp(char ch, int count) {

        this.ch = ch;
        this.count = count;
    }
}

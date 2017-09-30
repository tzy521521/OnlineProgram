package guoxingtong;

import java.util.*;

/**
 * Created by tzy on 2017/9/26.
 */
public class Main {
    public static void main(String[] args){
        Random r = new Random();
        ArrayList<Character> arrayList = new ArrayList<>();
            while (arrayList.size()<26){
                int randomNum = r.nextInt(122)%26 + 97;//随机生成a-z小写字母的ASCII码
                //int randomNum = r.nextInt(26) + 97;//随机生成a-z小写字母的ASCII码
                if (!arrayList.contains((char)randomNum))
                    arrayList.add((char)randomNum);
            }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);//翻转倒序
        for (Character character:arrayList) {
            System.out.print(character+" ");
        }
    }
}

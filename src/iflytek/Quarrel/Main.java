package iflytek.Quarrel;

import java.util.*;

/**
 * Created by tzy on 2017/9/16.
 * 课程冲突：TreeMap完美解决。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            TreeMap<String,ArrayList<String>> treeMap=new TreeMap<>();
            for (int i = 0; i <n ; i++) {
                String time=scanner.next();
                String kecheng=scanner.next();
                if (treeMap.containsKey(time)){
                    treeMap.get(time).add(kecheng);
                }else {
                    ArrayList<String> arrayList=new ArrayList<>();
                    arrayList.add(kecheng);
                    treeMap.put(time,arrayList);
                }
            }
            boolean flag=true;
            for (Map.Entry<String,ArrayList<String>> entry:treeMap.entrySet()) {
                if (entry.getValue().size()>1){
                    flag=false;
                    System.out.print(entry.getKey()+" ");
                    for (String string:entry.getValue()) {
                        System.out.print(string+" ");
                    }
                    System.out.println();
                }
            }
            if (flag)
                System.out.println("YES");

        }
    }
}

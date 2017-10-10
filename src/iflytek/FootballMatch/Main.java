package iflytek.FootballMatch;

import java.util.*;

/**
 * Created by tzy on 2017/10/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n =scanner.nextInt();
            HashMap<String,Integer> hashMap=new HashMap<>();
            for (int i = 0; i <n ; i++) {
                hashMap.put(scanner.next(),0);
            }
            for (int i = 0; i <n*(n-1)/2 ; i++) {
                String saicheng=scanner.next();
                int index=saicheng.indexOf("-");
                String team1=saicheng.substring(0,index);
                String team2=saicheng.substring(index+1);

                String result=scanner.next();
                int index1=result.indexOf(":");
                Integer team1_0=Integer.valueOf(result.substring(0,index1));
                Integer team2_0=Integer.valueOf(result.substring(index+1));
                if (team1_0>team2_0){
                    int value=hashMap.get(team1);
                    value++;
                    hashMap.put(team1,value);
                }else if (team1_0<team2_0){
                    int value=hashMap.get(team2);
                    value++;
                    hashMap.put(team2,value);
                }
            }
            ArrayList<Map.Entry<String,Integer>> arrayList=new ArrayList<>(hashMap.entrySet());
            //Collections.sort(arrayList,Map.Entry.comparingByValue());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue()>o2.getValue())
                        return 1;
                    else if (o1.getValue()<o2.getValue())
                        return -1;
                    else
                        return -(o1.getKey().compareTo(o2.getKey()));
                }
            });
            for (int j = n/2; j <arrayList.size() ; j++) {
                System.out.println(arrayList.get(j).getKey());
            }
        }
    }
}

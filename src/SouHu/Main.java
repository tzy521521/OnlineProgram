package SouHu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by tzy on 2017/9/2.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int nums=scanner.nextInt();
            ArrayList<Person> arrayList=new ArrayList<>();
            for (int i = 0; i <nums ; i++) {
                arrayList.add(new Person(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
            }
            Collections.sort(arrayList, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    int result=Integer.compare(o1.getWeight(),o2.getWeight());
                    if (result==0)
                        result=Integer.compare(o1.getHeight(),o2.getHeight());
                    return result;
                }
            });
            int max=0;
            int[] LIS_Height= LIS_Height(arrayList);
            for (int i:LIS_Height) {
                if (i>max)
                    max=i;
            }
            System.out.println(max);
        }
    }
    public static int[] LIS_Height(ArrayList<Person> arrayList){
        if (arrayList==null||arrayList.size()==0)
            return null;
        int[] f=new int[arrayList.size()];
        f[0]=1;
        for (int i = 1; i <arrayList.size(); i++) {
            int max=0;
            for (int j = 0; j <i ; j++) {
                /*
                身高，体重同时递增或者同时相等。
                 boolean flag1=arrayList.get(j).getWeight()==arrayList.get(i).getWeight()&&arrayList.get(j).getHeight()==arrayList.get(i).getHeight();
                boolean flag2=arrayList.get(j).getWeight()<arrayList.get(i).getWeight()&&arrayList.get(j).getHeight()<arrayList.get(i).getHeight();
                if ((flag1||flag2)&&f[j]>max)
                    max=f[j];
                 */
                //体重相同时，身高不递减；体重递增时，身高递增。
                boolean flag=arrayList.get(j).getWeight()==arrayList.get(i).getWeight()&&arrayList.get(j).getHeight()==arrayList.get(i).getHeight();
                if ((arrayList.get(j).getHeight()<arrayList.get(i).getHeight()||flag)&&f[j]>max)
                    max=f[j];
            }
            f[i]=max+1;
        }
        return f;
    }
    public static class Person{
        private int index;
        private int weight;
        private int height;

        public Person(int index, int weight, int height) {
            this.index = index;
            this.weight = weight;
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return "{weight=" + weight +
                    ", height=" + height +
                    '}';
        }
    }
}

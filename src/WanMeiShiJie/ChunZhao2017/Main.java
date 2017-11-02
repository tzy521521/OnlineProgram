package WanMeiShiJie.ChunZhao2017;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tzy on 2017/11/2
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            for (int i = 0; i <n ; i++) {
                add(scanner.nextInt());
            }
            for (int i = 0; i <k ; i++) {
                System.out.println(remove());
            }
        }
    }
    //用ArrayList<Integer>来存储堆
    private static ArrayList<Integer> list=new ArrayList<>();
    //创建小顶堆
    public static void add(int newObject){
        list.add(newObject);
        int currentIndex=list.size()-1;
        while (currentIndex>0){
            int parentIndex=(currentIndex-1)/2;
            if (list.get(currentIndex).compareTo(list.get(parentIndex))<0){
                int temp=list.get(currentIndex);
                list.set(currentIndex,list.get(parentIndex));
                list.set(parentIndex,temp);
            }
            else
                break;
            currentIndex=parentIndex;
        }
    }
    public static Integer remove(){
        if (list.size()==0)
            return null;
        Integer removeObject=list.get(0);
        list.set(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        int currentIndex=0;
        while (currentIndex<list.size()){
            int leftChildIndex=2*currentIndex+1;
            int rightChildIndex=2*currentIndex+2;
            if (leftChildIndex>=list.size())break;
            int minIndex=leftChildIndex;
            if (rightChildIndex<list.size()){
                if (list.get(minIndex).compareTo(list.get(rightChildIndex))>0){
                    minIndex=rightChildIndex;
                }
            }
            if (list.get(currentIndex).compareTo(list.get(minIndex))>0){
                Integer temp=list.get(minIndex);
                list.set(minIndex,list.get(currentIndex));
                list.set(currentIndex,temp);
                currentIndex=minIndex;
            }
            else
                break;
        }
        return removeObject;
    }
}


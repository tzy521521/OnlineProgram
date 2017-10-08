package Ctrip.ChunZhao2017.FindNumsAppearOnce;

import java.util.*;

/**
 * Created by tzy on 2017/9/5.
 * 剑指offer的题
 * 给定一个整形数组，请写一个算法，找到第一个仅出现一次的数组元素，复杂度O(n) 。
 * 输入:给定一整形数组，数组元素若干(1,1,2,2,3,3,4,4,5,6,6,8,9,9)
 * 输出:第一个仅出现一次的元素(5)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(",");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.valueOf(strings[i]);
            }
            System.out.println(findNumsAppearOnce(nums));
        }
    }
    public static int findNumsAppearOnce(int [] array){
        LinkedHashMap<Integer,Integer> linkedHashMap=new LinkedHashMap<>();
        for (int i = 0; i <array.length ; i++) {
            /*
            if (!linkedHashMap.containsKey(array[i]))
                linkedHashMap.put(array[i],1);
            else {
                int value=linkedHashMap.get(array[i]);
                value++;
                linkedHashMap.put(array[i],value);
            }
             */
            //java8的API。
            linkedHashMap.put(array[i],linkedHashMap.getOrDefault(array[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:linkedHashMap.entrySet()) {
            if (entry.getValue()==1)
                return entry.getKey();
        }
        return -1;
    }
}

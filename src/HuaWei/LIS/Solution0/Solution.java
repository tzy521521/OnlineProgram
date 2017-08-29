package HuaWei.LIS.Solution0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by tzy on 2017/8/29.
 * 求递增计数。
 */
public class Solution {
    //输出一条递增子序列
    public ArrayList<Integer> seqLISs(int[] students){
        int[] count=LIS(students);
        int length=length_LIS(students);
        ArrayList<Integer> arrayList=new ArrayList<>();
        int index=count.length-1;
        while (index>=0){
            if (count[index]==length){
                break;
            }
            index--;
        }
        seqLIS(students,count,arrayList,index);
        Collections.reverse(arrayList);
        return arrayList;
    }
    private void seqLIS(int[] students,int[] count,ArrayList<Integer> arrayList,int index){
        int k=count[index]-1;
        arrayList.add(students[index]);
        for (int i = index-1; i >=0 ; i--) {
            if (count[i]==k&&students[i]<arrayList.get(arrayList.size()-1)){
                arrayList.add(students[i]);
                k--;
            }
        }
    }
    //求最长递增子序列长度。
    public int length_LIS(int[] nums){
        if (nums==null||nums.length==0)
            return 0;
        int[] array=LIS(nums);
        Arrays.sort(array);
        return array[array.length-1];
    }
    //求递增计数。
    public int[] LIS(int[] nums){
        if (nums==null||nums.length==0)
            return null;
        int[] f=new int[nums.length];
        f[0]=1;
        for (int i = 1; i <nums.length ; i++) {
            int max=0;
            for (int j = 0; j <i ; j++) {
                if (nums[j]<nums[i]&&f[j]>max)
                    max=f[j];
            }
            f[i]=max+1;
        }
        return f;
    }
}

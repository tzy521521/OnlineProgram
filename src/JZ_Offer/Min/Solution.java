package JZ_Offer.Min;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tzy on 2017/8/16.
 */
public class Solution {
    private ArrayList<Integer> arrayList=new ArrayList<>();

    public void push(int node) {
        arrayList.add(node);
    }

    public void pop() {
        //如果栈为空应该抛出异常。
        arrayList.remove(arrayList.size()-1);
    }

    public int top() {
        //如果栈为空应该抛出异常。
        return arrayList.get(arrayList.size()-1);
    }

    public int min() {
        //如果栈为空应该抛出异常。
        ArrayList<Integer> temp=new ArrayList<>(arrayList);
        Collections.sort(temp);
        return temp.get(0);
    }
}

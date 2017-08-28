package HuaWei.Chorusline.Solution3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tzy on 2017/8/3.
 * 要求找出队列中连续最大的合唱队行，所要出列的人数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            int nums=input.nextInt();
            int[] students=new int[nums];
            for (int i = 0; i <nums ; i++) {
                students[i]=input.nextInt();
            }
            ArrayList<Integer>arrayList=new ArrayList<>();
            arrayList=process(students,arrayList);
            Collections.sort(arrayList);
            System.out.println(students.length-arrayList.get(arrayList.size()-1));
        }
    }
    public static ArrayList<Integer> process(int[] students, ArrayList<Integer> arrayList){
        if (students.length<3){
            arrayList.add(students.length);
            return arrayList;
        }

        int low=1;
        int temp=students[0];
        while (low<students.length){
            if (students[low]>temp)
            {
                temp=students[low];
                low++;
            } else{
                low--;
                break;
            }
        }

        int height=students.length-2;
        temp=students[students.length-1];
        while (height>=0){
            if (students[height]>temp){
                temp=students[height];
                height--;
            } else{
                height++;
                break;
            }
        }

        if (height+1==low){
            arrayList.add(students.length);
            return arrayList;
        }else if (height==low){
            arrayList.add(students.length);
            return arrayList;
        }else {
            if (low==0){
                arrayList.add(1);
                low++;
            }else {
                temp=students[low];
                low++;
                while (low<height){
                    if (students[low]<temp)
                    {
                        temp=students[low];
                        low++;
                    } else{
                        break;
                    }
                }
                arrayList.add(low);
            }


            if (height==students.length-1){
                height--;
            }else {
                temp=students[height];
                height--;
                while (height>low){
                    if (students[height]<temp)
                    {
                        temp=students[height];
                        height--;
                    } else{
                        break;
                    }
                }
                    arrayList.add(students.length-height);
            }


            int[] stu=new int[height-low+1];
            System.arraycopy(students,low,stu,0,stu.length);
            process(stu,arrayList);
        }

        return arrayList;
    }
}

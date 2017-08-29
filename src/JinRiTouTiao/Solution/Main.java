package JinRiTouTiao.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tzy on 2017/4/28.
 */
public class Main {
    public static void main(String[] args) {
        Student student1=new Student("Jame",100.0);
        Student student2=new Student("Sunan",90.0);
        Student student3=new Student("Audi",80.0);
        Student student4=new Student("Mycal",50.0);
        Student student5=new Student("Duew",90.0);
        Student student6=new Student("Mical",50.0);
        ArrayList<Student> arrayList=new ArrayList<>();
        arrayList.add(student1);arrayList.add(student2);arrayList.add(student3);
        arrayList.add(student4);arrayList.add(student5);arrayList.add(student6);
        sort(arrayList);
        for (Student student:arrayList) {
            System.out.println(student.getName()+" "+student.getScore());
        }
    }
 public static void sort(ArrayList<Student> arrayList){
     Collections.sort(arrayList, new Comparator<Student>() {
         @Override
         public int compare(Student student1, Student student2) {
             if (student1.getScore()>student2.getScore())
                 return 1;
             else if (student1.getScore()<student2.getScore())
                 return -1;
             else
                 return student1.getName().compareTo(student2.getName());
         }
     });
 }
}
class Student{
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

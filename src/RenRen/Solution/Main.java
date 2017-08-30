package RenRen.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by tzy on 2017/4/28.
 * 面试
 * 有N个学生的数据，将学生数据按成绩高低排序，如果成绩相同则按姓名字符的字母序排序
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            ArrayList<Student> arrayList=new ArrayList<>();
            int num=scanner.nextInt();
            for (int i = 0; i <num ; i++) {
                arrayList.add(new Student(scanner.next(),scanner.nextDouble()));
            }
            //java8 复合Lambda表达式。
            //arrayList.sort(Comparator.comparing(Student::getScore).thenComparing(Student::getName));

            //指定比较器。
            Collections.sort(arrayList,new Comparator<Student>() {
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
            for (Student student:arrayList) {
                System.out.println(student.getName()+" "+student.getScore());
            }

        }
 }
 public static class Student{
     private String name;
     private double score;

     public Student(String name, double score) {
         this.name = name;
         this.score = score;
     }

     public String getName() {
         return name;
     }

     public double getScore() {
         return score;
     }

     public void setScore(double score) {
         this.score = score;
     }
 }
}


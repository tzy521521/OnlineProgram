package JinRiTouTiao.Solution;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by tzy on 2017/5/7.
 */
public class Main1 {
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

        arrayList.sort(Comparator.comparing(Student::getScore).thenComparing(Student::getName));
        System.out.println(arrayList);
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

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}

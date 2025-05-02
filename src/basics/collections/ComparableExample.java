package basics.collections;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getId() - o.getId();
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student(1, "Prem"),
                new Student(2, "Pinky"),
                new Student(3, "Abhijit"),
                new Student(4, "Neha")
        );

        studentList.sort(null);
        System.out.println(studentList);
    }
}

import java.util.Comparator;

public class Student implements Comparable<Student>, Comparator<Student> {

    private String name;
    private int age;
    private int stip;

    Student(String name, int age, int stip) {
        this.name = name;
        this.age = age;
        this.stip = stip;
    }

    @Override
    public int compareTo(Student o) {
        if (this.stip>o.stip)return 1;
        if (this.stip>o.stip)return -1;
        return 0;
    }

    @Override
    public int compare(Student o1, Student o2) {

        if (o1.age>o2.age)return 1;
        if (o1.age<o2.age)return -1;
        return 0;
    }

    public static void main(String[] args) {
        Student student1 = new Student("student1", 18, 2000);
        Student student2 = new Student("student2", 20, 1800);
        Student student3 = new Student("student3", 19, 1700);
        Student student4 = new Student("student4", 21, 2100);
        Student student5 = new Student("student5", 20, 2000);

        System.out.println(student1.compareTo(student5));
        System.out.println(student1.compare(student2,student3));




    }
}

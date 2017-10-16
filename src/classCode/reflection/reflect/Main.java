package classCode.reflection.reflect;

import classCode.classStudentTwoVersion.Group;
import classCode.classStudentTwoVersion.Journal;
import classCode.classStudentTwoVersion.Lesson;
import classCode.classStudentTwoVersion.Student;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student((short) 1,
                "Семен",
                "Семенович",
                "Горбунков",
                Date.parse("1980/01/01"));

        Group group1 = new Group(1, "STC-05");
        group1.addStudent(student1);

        Lesson lesson1 = new Lesson(Date.parse("2017/01/01"), "Сериализация", (short) 1, "Иванов Иван Иванович");

        Set<Student> students1 = new HashSet<Student>();
        students1.add(student1);

        Journal journal1 = new Journal(lesson1);
        journal1.addGroup(group1);

        ClassPrinter classPrinter = new ClassPrinter(journal1);
        classPrinter.printInfo();


    }

}

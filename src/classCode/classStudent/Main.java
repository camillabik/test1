package classCode.classStudent;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Set<Student> students1 = new HashSet<>();
        Student student1 = new Student("Vasya", "Ivanovich", "Sidorov", Date.parse("1991/07/01"), (short) 1);
        Student student2 = new Student("Petya", "Petrovich", "Petrov", Date.parse("19901/09/11"), (short) 1);
        Student student = new Student("Sasha", "Vasilich", "Vasikin", Date.parse("1992/06/09"), (short) 1);
        students1.add(student1);
        students1.add(student2);
        students1.add(student);
        Group group01 = new Group(students1, 1, "01");


        Set<Student> students2 = new HashSet<>();
        Student student3 = new Student("Lena", "Petrovna", "Vasilkova", Date.parse("1993/01/19"), (short) 2);
        Student student4 = new Student("Senya", "Evgenevich", "Gribov", Date.parse("1990/02/15"), (short) 2);
        Student student5 = new Student("Vitya", "Nikitich", "Berezkin", Date.parse("1989/03/28"), (short) 2);
        students2.add(student3);
        students2.add(student4);
        students2.add(student5);
        Group group02 = new Group(students2, 2, "02");
        Lesson lesson01 = new Lesson("Serializable", Date.parse("2017/09/21"), (short) 1, "Artem");
        Lesson lesson02 = new Lesson("Multithreadinge", Date.parse("2017/09/22"), (short) 1, "Artem");
        Set<Student> present1 = new HashSet<>();
        present1.add(student);
        present1.add(student2);
        Set<Student> present2 = new HashSet<>();
        present2.add(student5);
        present2.add(student3);
        Map<Group,Set<Student>> presentMap1 = new HashMap<>();
        presentMap1.put(group01,present1);
        Journal journal = new Journal(lesson01, presentMap1);
        Map<Group,Set<Student>> presentMap2 = new HashMap<>();
        presentMap1.put(group02,present2);
        Journal journal2 = new Journal(lesson02, presentMap2);

        MySerialializationAction.serializeJournal(journal);
        System.out.println(MySerialializationAction.readJournalGroup());
        System.out.println(MySerialializationAction.readJournalLesson());
        System.out.println(MySerialializationAction.readJournalStudent());
        MySerialializationAction.serializeJournal(journal2);
        System.out.println(MySerialializationAction.readJournalGroup());
        System.out.println(MySerialializationAction.readJournalLesson());
        System.out.println(MySerialializationAction.readJournalStudent());
    }
    public static String journalAttendance(Journal journal){


        return "";
    }

    public static void printJournal(Journal journal)
    {
//        for (Field f : child.getClass().getFields()) {
//            System.out.println(f.getName() + " " + f.getType().getName() + " " + f.getModifiers());
//        }
//
//        for (Method m : child.getClass().getMethods()) {
//            System.out.println(m.getName() + " " + m.getReturnType().getName());
//            for (Parameter p : m.getParameters()) {
//                System.out.println("\t" + p.getName() + " " + p.getType().getName());
//            }
//        }

        for (Field field :journal.getClass().getFields()) {
            System.out.println(field.getName()+" "+field.getType().getName()+" "+field.getModifiers());
        }

        for (Method method: journal.getClass().getMethods()) {
            System.out.println(method.getName()+" "+method.getReturnType().getName());
            for (Parameter parameter: method.getParameters())
            {
                System.out.println("\t"+parameter.getName()+" "+ parameter.getType().getName());
            }
        }


    }
}

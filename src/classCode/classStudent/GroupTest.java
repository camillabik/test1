package classCode.classStudent;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    private static Group group;

    @BeforeAll
    static void setupGroup(){
        Set<Student> students1 = new HashSet<>();
        Student student1 = new Student("Vasya", "Ivanovich", "Sidorov", Date.parse("1991/07/01"), (short) 1);
        Student student2 = new Student("Petya", "Petrovich", "Petrov", Date.parse("19901/09/11"), (short) 1);
        Student student = new Student("Sasha", "Vasilich", "Vasikin", Date.parse("1992/06/09"), (short) 1);
        group = new Group(students1,1, "testGroup");
    }
    @BeforeEach
    void clearStudents(){
        group.setStudents(new HashSet<Student>());
    }

    @Test
    void setStudents() {

    }

    @Test
    void addStudent() {
        Set<Student> students1 = new HashSet<>();
        Student student1 = new Student("Vasya", "Ivanovich", "Sidorov", Date.parse("1991/07/01"), (short) 1);
        Group group01 = new Group(students1, 1, "01");
        group.addStudent(student1);
        assertEquals(1, group.getStudents().size());
        Student getStud = (Student) group.getStudents().toArray()[0];
        assertEquals(student1.getNum(), getStud.getNum());
        assertEquals(student1.getbData(), getStud.getbData());
        assertTrue(student1.getFamilyName().equals(getStud.getFamilyName()));
        assertTrue(student1.getFirstName().equals(getStud.getFirstName()));
        assertTrue(student1.getSecondName().equals(getStud.getSecondName()));

    }

    @Test
    void removeStudent() {
    }

}
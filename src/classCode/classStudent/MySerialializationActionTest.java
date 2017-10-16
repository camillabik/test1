package classCode.classStudent;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

import static org.mockito.Mockito.*;

class MySerialializationActionTest {
    @Test
    void readJournal() throws IOException, ClassNotFoundException {
        ObjectInputStream mockStream = mock(ObjectInputStream.class);
        Set<Student> students1 = new HashSet<>();
        Student student1 = new Student("Vasya", "Ivanovich", "Sidorov", Date.parse("1991/07/01"), (short) 1);
        Student student2 = new Student("Petya", "Petrovich", "Petrov", Date.parse("19901/09/11"), (short) 1);
        Student student = new Student("Sasha", "Vasilich", "Vasikin", Date.parse("1992/06/09"), (short) 1);
        students1.add(student1);
        students1.add(student2);
        students1.add(student);
        Group group01 = new Group(students1, 1, "01");
        Map<Group,Set<Student>> presentMap1 = new HashMap<>();
        Lesson lesson01 = new Lesson("Serializable", Date.parse("2017/09/21"), (short) 1, "Artem");
        Lesson lesson02 = new Lesson("Multithreadinge", Date.parse("2017/09/22"), (short) 1, "Artem");
        Set<Student> present1 = new HashSet<>();
        presentMap1.put(group01,present1);
        Journal journal = new Journal(lesson01, presentMap1);
        present1.add(student);
        present1.add(student2);
        when(mockStream.readObject()).thenReturn(journal);
        HashSet<Journal> journals = new HashSet<>();
        journals.add((Journal) mockStream.readObject());

    }

}
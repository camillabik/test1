package classCode.classStudent;

import java.io.*;
import java.util.Map;
import java.util.Set;

public class MySerialializationAction {
    public static ObjectInputStream ois;

    static void serializeJournal(Journal journal) throws IOException {
        File file = new File("journal_group.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(journal);

        File file2 = new File("journal_student.txt");
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(file2));
        oos1.writeObject(journal);

        File file3 = new File("journal_lesson.txt");
        ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream(file3));
        oos3.writeObject(journal);
    }
    static Journal readJournal (ObjectInputStream ois) throws IOException, ClassNotFoundException {
        Journal journal = (Journal) ois.readObject();
        return journal;
    }

    static String readJournalGroup() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("journal_group.txt"));

        StringBuilder rezult = new StringBuilder("");
        for (Map.Entry<Group,Set<Student>> entry: readJournal(ois).getPresentMap().entrySet()) {
            rezult.append(String.format("Lesson: %s, group №: %s, total number of students: %d, present: %d %n" ,readJournal(ois).getLesson().getTopic(),
                    entry.getKey().getGroupName(), entry.getKey().getStudents().size(), entry.getValue().size()));
        }
        return String.valueOf(rezult);
    }

    static String readJournalStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("journal_student.txt"));
        Journal journal = (Journal) ois.readObject();
        StringBuilder rezult = new StringBuilder("");
        for (Map.Entry<Group,Set<Student>> entry: journal.getPresentMap().entrySet()) {
            for (Student student :entry.getKey().getStudents()) {
                rezult.append(String.format("Student name %s %s %s, lesson: %s, date: %tl, attended the lesson: %s %n", student.getFirstName(), student.getSecondName(),
                        student.getFamilyName(),journal.getLesson().getTopic(), journal.getLesson().getDateTime(),
                       entry.getValue().contains(student)?"yes":"no"));
            }
        }
        return String.valueOf(rezult);
    }

    static String readJournalLesson() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("journal_lesson.txt"));
        Journal journal = (Journal) ois.readObject();
        String rezult;
        int attenStudent = 0;
        for (Map.Entry<Group,Set<Student>> entry: journal.getPresentMap().entrySet()) {
           attenStudent += entry.getValue().size();
        }
        rezult =  String.format("Lesson: %s, number of students %d", journal.getLesson().getTopic(), attenStudent);
        return rezult;
    }
    
}

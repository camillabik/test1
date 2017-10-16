package classCode.classStudent;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    static Student student;
    @BeforeAll
    static void setupStudent()
    {
        Student student1 = new Student("Vasya", "Ivanovich", "Sidorov", Date.parse("1991/07/01"), (short) 1);
    }
    @BeforeEach
    void clearStudent()
    {

    }
    @Test
    void equals()
    {

    }

}
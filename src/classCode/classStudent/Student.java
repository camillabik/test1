package classCode.classStudent;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
    private String firstName;
    private String secondName;
    private String familyName;
    private final long bData;
    private final short num;

    public Student(String firstName, String secondName, String familyName, long bData, short num) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.familyName = familyName;
        this.bData = bData;
        this.num = num;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public long getbData() {
        return bData;
    }

    public short getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (bData != student.bData) return false;
        return num == student.num;
    }

    @Override
    public int hashCode() {
        int result = (int) (bData ^ (bData >>> 32));
        result = 31 * result + (int) num;
        return result;
    }


}

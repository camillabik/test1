package classCode.classStudent;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Group implements Serializable{
    private Set<Student> students = new HashSet<>();
    private final int groupNum;
    private final  String groupName;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Group(Set<Student> students, int groupNum, String groupName) {
        this.students = students;
        this.groupNum = groupNum;
        this.groupName = groupName;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(Student student)
    {
        students.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (groupNum != group.groupNum) return false;
        return groupName != null ? groupName.equals(group.groupName) : group.groupName == null;
    }

    @Override
    public int hashCode() {
        int result = groupNum;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public String getGroupName() {
        return groupName;
    }
}

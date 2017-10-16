package classCode.classStudent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Journal implements Serializable{
    private Lesson lesson;
    private Map<Group,Set<Student>> presentMap = new HashMap<>();
    private Set<Group> groups = new HashSet<>();

    public Journal(Lesson lesson, Map<Group,Set<Student>> presentMap) {
        this.lesson = lesson;
        this.presentMap = presentMap;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Map<Group, Set<Student>> getPresentMap() {
        return presentMap;
    }

    public void setPresentMap(Map<Group, Set<Student>> presentMap) {
        this.presentMap = presentMap;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}

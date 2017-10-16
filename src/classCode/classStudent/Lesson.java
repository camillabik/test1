package classCode.classStudent;


import java.io.Serializable;

public class Lesson implements Serializable{
    private final String topic;
    private final long dateTime;
    private final short roomNum;
    private final String teachName;

    public Lesson(String topic, long dateTime, short roomNum, String teachName) {
        this.topic = topic;
        this.dateTime = dateTime;
        this.roomNum = roomNum;
        this.teachName = teachName;
    }

    public String getTopic() {
        return topic;
    }

    public long getDateTime() {
        return dateTime;
    }


    public short getRoomNum() {
        return roomNum;
    }

    public String getTeachName() {
        return teachName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;

        if (dateTime != lesson.dateTime) return false;
        if (roomNum != lesson.roomNum) return false;
        if (!topic.equals(lesson.topic)) return false;
        return teachName.equals(lesson.teachName);
    }

    @Override
    public int hashCode() {
        int result = topic.hashCode();
        result = 31 * result + (int) (dateTime ^ (dateTime >>> 32));
        result = 31 * result + (int) roomNum;
        result = 31 * result + teachName.hashCode();
        return result;
    }
}

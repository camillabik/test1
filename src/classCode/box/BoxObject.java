package classCode.box;

public class BoxObject {
    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    public void print(Object value)
    {
        System.out.println(value);
    }
}

package classCode.box;

import sun.net.www.content.text.Generic;

public class BoxGeneric<T extends Comparable<T>> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public void print(Generic value){
        System.out.println(value);
    }
    public int compareTo(T obj){
        return this.value.compareTo(obj);
    }
}

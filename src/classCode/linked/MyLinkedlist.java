package classCode.linked;

import java.util.LinkedList;

public class MyLinkedlist<T> {
    private int size = 0;
    private MyNode<T> first;
    private MyNode<T> last;

    public MyLinkedlist() {
        first = new MyNode<T>(null, last, null);
        last = new MyNode<>(null, null, first);
    }

    private static class MyNode<T>{
        T currentElem;
        MyNode<T> next;
        MyNode<T> prev;

        public MyNode(T currentElem, MyNode<T> next, MyNode<T> prev) {
            this.currentElem = currentElem;
            this.next = next;
            this.prev = prev;
        }

        public T getCurrentElem() {
            return currentElem;
        }

        public void setCurrentElem(T currentElem) {
            this.currentElem = currentElem;
        }

        public MyNode<T> getNext() {
            return next;
        }

        public void setNext(MyNode<T> next) {
            this.next = next;
        }

        public MyNode<T> getPrev() {
            return prev;
        }

        public void setPrev(MyNode<T> prev) {
            this.prev = prev;
        }
    }

    public void add(T elem){}
    public void add(int index, T elem){}
    public T get(int index) {
        return null;
    }
    public T getFirst() {
        return null;
    }
    public T getLast() {
        return null;
    }
    public void set(int index, T elem){}
    public void setFirst(T elem){}
    public void setLast(T elem){}

    public T remove(int index){
        return null;
    }
    public T remove(){
        return null;
    }
    public boolean contains(T elem){
        return false;
    }
    public void linkBefore(T elem, MyNode<T> node){}
    public void linkAfter(T elem, MyNode<T> node){}



}

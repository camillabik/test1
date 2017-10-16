package classCode.array;


public  class MyArrayList<T>{
    private int capacity;
    private Object[] elem;

    private int point = 0;
    MyArrayList(int cap){
        capacity = cap;
        if (capacity>0) {
            this.elem = new Object[capacity];
        }
        if (capacity==0)this.elem = new Object[]{};
        else if (capacity<0)throw new IllegalArgumentException("Capacity = " + capacity);
    }
    MyArrayList(){
        this.elem = new Object[4];
        capacity = 4;
    }

    public void addElem(T obj){
        if (point==elem.length-1) resize();
        elem[point++] = obj;
    }

    public Object get(int index)
    {
        return (T) elem[index];
    }

    public void remove(int index)
    {
        for (int i = index; i < point; i++) {
            elem[index] = elem[index+1];
        }
        elem[point] = null;
        point--;
    }
    public int size() {
        return point;
    }
    public void resize()
    {
        Object[] arrays = new Object[point*2];
        System.arraycopy(elem, 0, arrays,0, point+1);
        elem = arrays;
        capacity = point*2;

    }
    public boolean contains(T o)
    {
        for (Object t : elem) {
            if (o.equals(t)) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList();
        myArrayList.addElem("Весна");
        myArrayList.addElem("Лето");
        myArrayList.addElem("Зима");
        myArrayList.addElem("Осень");
//        System.out.println("Размер списка "+myArrayList.size());
//        System.out.println("Чего не было в этом году: "+myArrayList.get(1));
//        myArrayList.remove(3);
//        System.out.println("Размер списка "+myArrayList.size());
//        System.out.println(myArrayList.contains("jfjf"));
//        System.out.println(myArrayList.contains("Весна"));
//        for (int i = 0; i < myArrayList.size(); i++) {
//            System.out.println(myArrayList.get(i));
//        }
//        System.out.println(new MyArrayList<String>(24).capacity);
//        MyArrayList<String> mal = new MyArrayList<>(24);
//        System.out.println(mal.capacity);
//        myArrayList.resize();
//        System.out.println(myArrayList.capacity);
//
       myArrayList.addElem("djdjd");
       System.out.println(myArrayList.capacity);

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }


    }
}


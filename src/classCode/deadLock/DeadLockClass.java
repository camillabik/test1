package classCode.deadLock;

public class DeadLockClass {
   private final Object lock = new Object();

   synchronized void someMet1(){
        synchronized (lock)
        {
            dosomething();
        }
    }

    void someMet2(){
       synchronized (lock){
           synchronized (this)
           {
               dosomething();
           }
       }
    }

    void dosomething(){}

    public static void main(String[] args) {
       DeadLockClass deadLockClass = new DeadLockClass();

        deadLockClass.someMet2();
        deadLockClass.someMet1();
    }
}

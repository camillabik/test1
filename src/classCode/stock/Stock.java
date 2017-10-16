package classCode.stock;

import java.util.concurrent.Semaphore;

public class Stock {

    Semaphore semaphore = new Semaphore(3, true);

    static void addProduct(int breadWare, int milkWare, int bearWare)
    {

    }
    public static void main(String[] args) {
     Thread thread1 = new Thread(new Runnable() {
         @Override
         public void run() {
             addProduct(7,0,0);
         }
     });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                addProduct(0,5,0);
            }
        });
   }
    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            addProduct(0,0,1);
        }
    });
    Thread thread4 = new Thread(new Runnable() {
        @Override
        public void run() {
            addProduct(0,4,0);
        }
    });
    Thread thread5 = new Thread(new Runnable() {
        @Override
        public void run() {
            addProduct(5,0,0);
        }
    });
    Thread thread6 = new Thread(new Runnable() {
        @Override
        public void run() {
            addProduct(0,7,0);
        }
    });
}


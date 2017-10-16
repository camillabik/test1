package classCode.clock;

public class Chronometer implements Runnable {
    private int secondCount;

    public int getSecondCount() {
        return secondCount;
    }

    @Override
    public void run() {

        while (true) {
            count();
        }
    }

    public synchronized void count(){
        notifyAll();
        try {
            Thread.sleep(1000);
            secondCount++;
            System.out.println(secondCount);
//            if (secondCount!=0&&secondCount%5==0)
//            {
//               wait();
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

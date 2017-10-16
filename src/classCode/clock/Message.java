package classCode.clock;

public class Message implements Runnable {
    Chronometer chronometer;

    public Message(Chronometer chronometer) {
        this.chronometer = chronometer;
    }

    @Override
    public void run() {
        while (true) {
            mess();
        }
    }

    public synchronized void mess() {
        if (chronometer.getSecondCount() % 5 == 0 && chronometer.getSecondCount() != 0) {
                System.out.println("Прошло пять секунд");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}

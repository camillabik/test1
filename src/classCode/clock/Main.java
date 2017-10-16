package classCode.clock;

public class Main {
    public static void main(String[] args) {
        Chronometer chronometer = new Chronometer();
        Thread threadChron = new Thread(chronometer);
        Thread threadMess = new Thread(new Message(chronometer));
        threadChron.start();
        threadMess.start();


    }
}

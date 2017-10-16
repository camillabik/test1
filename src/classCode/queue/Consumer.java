package classCode.queue;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private Producer producer;
    private int count = 0;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {

            String s = null;
            try {
                s = producer.getLinkedBlockingQueue().take();
                s = s.replaceAll("[\\p{P}]", "");
                String[] arr = s.split("[\\s+]");
                for (String s1 : arr) {
                    if (s1.equals("страдание"))
                        count++;
                    if(s1.equals("stop!!!!"))
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Cловo \"страдание\" встречается " + count+ "раз(а)");



        }

    }
}

package classCode.queue;


import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
   private String path;
   private LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();


    public Producer(String path) {
        this.path = path;
    }

    @Override
    public void run() {

        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while (((line = reader.readLine()) != null)) {
                linkedBlockingQueue.put(line);
            }
            linkedBlockingQueue.put("stop!!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public LinkedBlockingQueue<String> getLinkedBlockingQueue() {
        return linkedBlockingQueue;
    }

}

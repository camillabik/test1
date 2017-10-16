package classCode.queue;

public class MyQueue {

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer("C:\\Users\\admin\\IdeaProjects\\test1\\src\\classCode\\queue\\vim.txt");
        Consumer consumer = new Consumer(producer);
        Thread threadProd = new Thread(producer);
        Thread threadCons = new Thread(consumer);
        threadProd.start();
        Thread.sleep(100);
        threadCons.start();

    }

}

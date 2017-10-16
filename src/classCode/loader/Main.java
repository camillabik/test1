package classCode.loader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread updater = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ClassLoader loader = Printer.class.getClassLoader();
                try {
                    loader.loadClass("classCode.loader.Printer");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        updater.start();

        while (true)
        {
            Printer.print();
        }
    }
}

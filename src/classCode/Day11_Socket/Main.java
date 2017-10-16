package classCode.Day11_Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        String host = "10.240.22.179";
        int port = 4441;

        Server server = new Server(port);
        Thread threadServer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server.CreateServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        threadServer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Client client = new Client(host, port);
        client.CreateClint();

    }
}

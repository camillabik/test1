package classCode.Day11_Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void CreateServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Waiting client");
        Socket socket = serverSocket.accept();
        System.out.println("Клиент подключен");

        InputStream inputStream = socket.getInputStream();
        DataInputStream das = new DataInputStream(inputStream);

        while (true){
            String message = das.readUTF();
            System.out.println("Сообщение: " + message);
        }

    }

}

package classCode.cerver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4443);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("We got a client!");
        InputStream inputStream = socket.getInputStream();
        DataInputStream das = new DataInputStream(inputStream);
        while (true)
        {
            String message = das.readUTF();
            System.out.println(message);
        }

    }
}

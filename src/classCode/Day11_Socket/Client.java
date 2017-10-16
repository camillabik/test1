package classCode.Day11_Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String host = "";
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void CreateClint() throws IOException {
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);

        while (true){
            Scanner scanner = new Scanner(System.in);
            String message = scanner.next();

            dos.writeUTF(message);
        }
    }

}


//10.240.21.255

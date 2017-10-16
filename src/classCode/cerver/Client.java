package classCode.cerver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4443);

        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            String massage = scanner.next();

            dos.writeUTF(massage);
            System.out.println(massage);
        }
    }
}

package classCode.datagramSocket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class DatagramClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        InetAddress id = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), id, 4443);

        ds.send(packet);
        ds.close();

    }
}

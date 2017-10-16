package classCode.datagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(4443);

        byte[] packetMas = new byte[1024];
        DatagramPacket packet = new DatagramPacket(packetMas, 1024);
        ds.receive(packet);

//        String message =



    }
}

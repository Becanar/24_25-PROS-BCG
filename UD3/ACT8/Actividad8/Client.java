package Actividad8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) {
        int serverPort = 12346; // server port
        int clientPort = 34568; // client port
        byte number = 4; // number to send

        try {
            // create socket to send and receive
            DatagramSocket socket = new DatagramSocket(clientPort);
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // prepare packet
            byte[] buffer = {number};
            DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);

            // send packet
            socket.send(sendPacket);
            System.out.println("Esperando respuesta...");

            // buffer to receive response
            byte[] responseBuffer = new byte[1024];
            DatagramPacket receivedPacket = new DatagramPacket(responseBuffer, responseBuffer.length);

            // wait for response
            socket.receive(receivedPacket);

            // display response
            String response = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            System.out.println("Esperando respuesta...: " + response);

            // close socket
            System.out.println("Adiós...");
            socket.close();

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}


package Actividad8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        int port = 12346; // port to listen
        try {
            // create socket to listen
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Esperando datagrama...");

            // buffer to receive data
            byte[] buffer = new byte[1];
            DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);

            // wait to receive
            socket.receive(receivedPacket);

            // extract data from received
            byte number = receivedPacket.getData()[0];
            System.out.println("Vamos a calcular el cubo de: " + number);
            System.out.println("IP de origen: " + receivedPacket.getAddress());
            System.out.println("Puerto de origen: " + receivedPacket.getPort());

            // cube
            int cube = number * number * number;

            // response packet
            String response = "El cubo de " + number + " es " + cube;
            byte[] responseBytes = response.getBytes();
            InetAddress clientAddress = receivedPacket.getAddress();
            int clientPort = receivedPacket.getPort();
            DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, clientAddress, clientPort);

            // send response
            System.out.println("Enviamos el resultado... " + cube);
            socket.send(responsePacket);

            // close socket
            System.out.println("Adiósss");
            socket.close();

        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}


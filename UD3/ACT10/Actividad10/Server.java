package Actividad10;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12348; // port to listen

        try {
            // create socket
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Esperando datagrama.......");

            // prepare a buffer to receive data
            byte[] buffer = new byte[1024];
            DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);

            // receive the data
            socket.receive(receivedPacket);
            System.out.println("Recibo el objeto...");

            // deserialize the received object
            ByteArrayInputStream bais = new ByteArrayInputStream(receivedPacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Tenista tenista = (Tenista) ois.readObject();
            System.out.println("Recibo el objeto: " + tenista.getApellido() + " " + tenista.getAltura());

            // print info
            System.out.println("IP de origen: " + receivedPacket.getAddress());
            System.out.println("Puerto de origen: " + receivedPacket.getPort());

            // modify tenista
            tenista.setApellido("Karlovic");
            tenista.setAltura(208);
            System.out.println("Envío el objeto: " + tenista.getApellido() + " " + tenista.getAltura());

            // serialize tenist
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            oos.flush();

            // send modified object back
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivedPacket.getAddress(), receivedPacket.getPort());
            socket.send(sendPacket);

            // close resources
            System.out.println("Fin del servidor");
            socket.close();
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}


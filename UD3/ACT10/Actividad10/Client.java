package Actividad10;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // server hostname
        int serverPort = 12348;   // server port
        int clientPort = 34567;   // client port

        try {
            // create socket
            DatagramSocket socket = new DatagramSocket(clientPort);

            // create and serialize tenista
            Tenista tenista = new Tenista("del Potro", 198);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            oos.flush();

            // send tenista
            byte[] sendData = baos.toByteArray();
            InetAddress serverAddress = InetAddress.getByName(host);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);
            System.out.println("Envío el objeto: " + tenista.getApellido() + " " + tenista.getAltura());

            // receive modified object
            System.out.println("Esperando datagrama.......");
            byte[] buffer = new byte[1024];
            DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivedPacket);

            // deserialize object
            ByteArrayInputStream bais = new ByteArrayInputStream(receivedPacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Tenista modifiedTenista = (Tenista) ois.readObject();
            System.out.println("He recibido el objeto: " + modifiedTenista.getApellido() + " " + modifiedTenista.getAltura());

            // close resources
            System.out.println("Fin del cliente");
            socket.close();
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}


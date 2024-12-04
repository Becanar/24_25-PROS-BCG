package Actividad6;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 6010; // port to listen
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Esperando al cliente.....");
            Socket clientSocket = serverSocket.accept(); // accept connection

            // streams to communicate
            try (DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())) {

                System.out.println("Cliente conectado.");

                // reads number from client
                int number = input.readInt();
                System.out.println("Número recibido del cliente: " + number);

                // square
                int squared = number * number;

                // send the square
                output.writeUTF("El cuadrado del número " + number + " es " + squared);
                System.out.println("Resultado enviado al cliente.");
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}



package Actividad7;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 6013; // port to listen
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Esperando a los clientes.....");

            for (int i = 1; i <= 3; i++) {
                Socket clientSocket = serverSocket.accept(); // accept connection

                // streams to communicate
                try (DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())) {
                    System.out.println("Cliente " + i + " conectado.");

                    // send a message
                    output.writeUTF("Hola cliente " + i);
                    System.out.println("Mensaje enviado al cliente " + i + ".");
                }
                clientSocket.close(); // close socket
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}


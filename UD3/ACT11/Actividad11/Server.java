package Actividad11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 6000; // port to listen

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server iniciado. Esperando clientes...");

            // infinite loop to handle multiple clients
            while (true) {
                Socket clientSocket = serverSocket.accept(); // accept client
                System.out.println("Cliente Conectado.....");
                // handle the conection
                new HiloServidor(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}


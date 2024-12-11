package Actividad11;

import java.io.*;
import java.net.Socket;

public class HiloServidor extends Thread {
    private final Socket clientSocket;

    // client socket
    public HiloServidor(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Comunico con: " + clientSocket);

                if ("*".equals(message)) {
                    System.out.println("Fin de la conexión con: " + clientSocket);
                    break; // exit if is *
                }

                // convert to capital letters and upload
                output.println(message.toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el socket: " + e.getMessage());
            }
        }
    }
}


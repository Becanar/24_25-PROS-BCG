package Actividad7;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // server hostname
        int port = 6013; // server port

        System.out.println("PROGRAMA CLIENTE INICIANDO");
        try (Socket socket = new Socket(host, port);
             DataInputStream input = new DataInputStream(socket.getInputStream())) {

            // read and print the response
            String response = input.readUTF();
            System.out.println("Recibiendo mensaje del servidor: \n\t" + response);

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}


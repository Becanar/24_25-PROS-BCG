package Actividad6;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // server hostname
        int port = 6010; // server port

        System.out.println("PROGRAMA CLIENTE INICIANDO");
        try (Socket socket = new Socket(host, port)) {
            System.out.println("Introduce un número");

            // read number
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            // streams to communicate
            try (DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                 DataInputStream input = new DataInputStream(socket.getInputStream())) {

                // send the numbre
                output.writeInt(number);

                // read and print the response
                String response = input.readUTF();
                System.out.println("Recibiendo mensaje del servidor: \n\t" + response);
            }

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}


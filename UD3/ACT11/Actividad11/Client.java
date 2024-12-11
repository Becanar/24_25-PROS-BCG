package Actividad11;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // hostname
        int port = 6000;          // port

        System.out.println("PROGRAMA CLIENTE INICIANDO");

        try (Socket socket = new Socket(host, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            String userInput;
            do {
                System.out.print("Introduce una cadena: ");
                userInput = scanner.nextLine();

                // send input
                output.println(userInput);

                // receive and print response
                String response = input.readLine();
                System.out.println("=>Respuesta:" + response);

            } while (!"*".equals(userInput));

            System.out.println("Fin del envío....");

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}


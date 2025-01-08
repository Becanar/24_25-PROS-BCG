import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class Actividad1 {

    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();

        try {
            System.out.println("Nos conectamos a ftp.rediris.es");

            // connect server
            ftpClient.connect("ftp.rediris.es");

            // login
            boolean login = ftpClient.login("anonymous", "dm2");

            // check login
            if (login) {
                System.out.println("Login correcto");
                System.out.println("Directorio actual: " + ftpClient.printWorkingDirectory());

                // try to create the directory
                boolean dirCreated = ftpClient.makeDirectory("DM2PROS");

                if (dirCreated) {
                    System.out.println("Directorio creado....");
                } else {
                    System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");
                }

                // try logout
                boolean logout = ftpClient.logout();
                if (logout) {
                    System.out.println("Logout del servidor FTP...");
                } else {
                    System.out.println("Error al hacer logout...");
                }

            } else {
                System.out.println("Login incorrecto...");
            }

        } catch (IOException e) {
            System.out.println("Error al conectar o realizar operaciones en el servidor FTP.");
            e.printStackTrace();
        } finally {
            try {
                //desconnect
                ftpClient.disconnect();
                System.out.println("Desconectado...");
            } catch (IOException e) {
                System.out.println("Error al desconectar del servidor FTP.");
            }
        }
    }
}

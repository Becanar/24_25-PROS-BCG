import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class Actividad2 {
    public static void main(String[] args) {

        FTPClient ftpClient = new FTPClient();

        String servidor = "172.20.14.134";
        String usuario = "dinux";
        String contrasena = "dinux";
        boolean directorioCreado = false;

        try {
            System.out.println("Nos conectamos a " + servidor);
            ftpClient.connect(servidor);


            int respuesta = ftpClient.getReplyCode();
            if (respuesta != 220) {  // Código de éxito para la conexión: 220
                System.out.println("No se pudo conectar al servidor FTP. Código de respuesta: " + respuesta);
                return;
            }

            boolean login = ftpClient.login(usuario, contrasena);

            if (login) {
                System.out.println("Login correcto");

                String directorioActual = ftpClient.printWorkingDirectory();
                System.out.println("Directorio actual: " + directorioActual);

                String apellido = "apellido";
                String nombreDirectorio = "aplicacionweb" + apellido;

                // Crear los directorios dentro de la ruta "nombreDirectorio"
                directorioCreado = ftpClient.makeDirectory(nombreDirectorio + "/html");
                directorioCreado &= ftpClient.makeDirectory(nombreDirectorio + "/imagenes");
                directorioCreado &= ftpClient.makeDirectory(nombreDirectorio + "/css");

                if (directorioCreado) {
                    System.out.println("Directorios creados...");
                } else {
                    System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
                }

                // Logout
                boolean logout = ftpClient.logout();
                if (logout) {
                    System.out.println("Logout del servidor FTP...");
                } else {
                    System.out.println("Error al hacer logout...");
                }

                ftpClient.disconnect();
                System.out.println("Desconectado...");
            } else {
                System.out.println("Login incorrecto...");
            }
        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad3 {
    public static void main(String[] args) {
        try {
            // we see if there is an argument
            if (args.length == 0) {
                System.out.println("Direcciones IP locales:");

                // obtains the local IP address
                InetAddress local = InetAddress.getLocalHost();

                //prints the host name
                System.out.println("Nombre: " + local.getHostName());

                //obtains and prints other addresses with the host name
                for (InetAddress addr : InetAddress.getAllByName(local.getHostName())) {
                    System.out.println(addr);
                }
            } else {
               //domain
                System.out.println("Dirección IP de: " + args[0]);

                // obtains IP from domain
                InetAddress address = InetAddress.getByName(args[0]);

                // print hostname
                System.out.println("Nombre: " + address.getHostName());

                System.out.println(address);
            }
        } catch (UnknownHostException e) {
            // we manage error
            System.err.println("Error obteniendo las direcciones: " + e.getMessage());
        }
    }
}

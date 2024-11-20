import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad2 {
    public static void main(String[] args) {
        //we print an error if no argument is passed
        if (args.length == 0) {
            System.out.println("Se necesita una URL para obtener su dirección");
            return;
        }

        try {
            System.out.println("Las direcciones asociadas a " + args[0] + " son:");
            InetAddress[] addresses = InetAddress.getAllByName(args[0]);//we take addresses from the website
            for (InetAddress address : addresses) {
                //we iterate the addresses to print them
                System.out.println(address);
            }
        } catch (UnknownHostException e) {
            //we handle error
            System.err.println("No se pudo resolver el dominio: " + e.getMessage());
        }
    }
}

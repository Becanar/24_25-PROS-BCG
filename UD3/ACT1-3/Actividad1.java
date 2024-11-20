import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad1 {
    public static void main(String[] args) {
        try {
            System.out.println("Direcciones asociadas a Spotify:");
            InetAddress[] addresses = InetAddress.getAllByName("www.spotify.com");//we take addresses from the website
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

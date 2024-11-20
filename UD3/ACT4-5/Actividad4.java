import java.net.URI;

public class Actividad4 {
    private static void Visualizar(URI uri) {
        // print URI
        System.out.println("URI: " + uri);

        // print host
        System.out.println("\tHost: " + uri.getHost());

        // print the port (-1 if not exists)
        System.out.println("\tPort: " + uri.getPort());

        // print the path
        System.out.println("\tPath: " + uri.getPath());

        // print the schema
        System.out.println("\tScheme: " + uri.getScheme());

        // print the authority
        System.out.println("\tAuthority: " + uri.getAuthority());
    }

    public static void main(String[] args) {
        try {
            Visualizar(new URI("http://docs.oracle.com"));
            Visualizar(new URI("http://docs.oracle.com/javase/7"));
            Visualizar(new URI("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html"));
        } catch (Exception e) {
            // handle the error
            System.err.println("Error al procesar URI: " + e.getMessage());
        }
    }
}

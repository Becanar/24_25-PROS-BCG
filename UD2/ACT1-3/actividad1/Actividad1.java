package actividad1;

public class Actividad1 {
    public static void main(String[] args) {
        // create the threads
        Hilo primero = new Hilo("Primero");
        Hilo segundo = new Hilo("Segundo");

        // start the threads
        primero.start();
        segundo.start();

        // final message
        System.out.println("Fin programa");
    }
}
// thread class
class Hilo extends Thread {
    private String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    // define the thread what to do
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(nombre + " " + i);
        }
    }
}

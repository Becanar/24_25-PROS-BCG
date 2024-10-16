public class Actividad4 {
    public static void main(String[] args) {
        //create threads
        Thread p = new Thread(new Posicion("Primero"));
        Thread s = new Thread(new Posicion("Segundo"));
        //start threads
        p.start();
        s.start();
        //join to print the final message at the end
        try {
            p.join();
            s.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin programa");
    }
}
//thread class
class Posicion implements Runnable {
    private String mensaje;

    public Posicion(String mensaje) {
        this.mensaje = mensaje;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println(mensaje + " " + i);
        }
    }
}

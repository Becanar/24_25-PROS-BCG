public class Actividad2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ERROR! NO HAY ARGUMENTOS!");
            return;
        }

        int n = Integer.parseInt(args[0]);

        // create and start threads
        for (int i = 1; i <= n; i++) {
            Hilo hilo = new Hilo(i);
            hilo.start();
        }

        System.out.println("Final Programa");
    }
}
//thread class
class Hilo extends Thread {
    private int numero;

    public Hilo(int numero) {
        this.numero = numero;
    }

    // define the run method
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Hilo " + numero + " - mensaje " + i);
        }
    }
}
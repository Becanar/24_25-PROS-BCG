public class Actividad16 {
    public static void main(String[] args) {
        Contador cont = new Contador(100);
        HiloA a = new HiloA("HiloA", cont);
        HiloB b = new HiloB("HiloB", cont);

        a.start();
        try {
            // wait HiloA to finish
            a.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        b.start();
    }
}

class Contador {
    private int c;

    Contador(int c) {
        this.c = c;
    }

    //  increment method
    public synchronized void incrementa() {
        c = c + 1;
    }

    //  decrement method
    public synchronized void decrementa() {
        c = c - 1;
    }

    public synchronized int getValor() {
        return c;
    }
}

class HiloA extends Thread {
    private Contador contador;

    public HiloA(String n, Contador c) {
        setName(n);
        contador = c;
    }

    public void run() {
        for (int j = 0; j < 300; j++) {
            contador.incrementa();
            try {
                // reducedd the sleep time to make execution faster
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}

class HiloB extends Thread {
    private Contador contador;

    public HiloB(String n, Contador c) {
        setName(n);
        contador = c;
    }

    public void run() {
        for (int j = 0; j < 300; j++) {
            contador.decrementa();
            try {
                // reduced the sleep time to make execution faster
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}
